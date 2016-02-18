package com.catalyst.springboot.webservices;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catalyst.springboot.entities.Receipt;
import com.catalyst.springboot.services.ReceiptService;

/**
 * A WebService for our Receipt class, with separate routes for images, and
 * their corresponding data.
 * 
 * @author atatro
 */
@RestController
public class ReceiptWebServices {
	
	@Autowired
	ReceiptService receiptService;
	
	/**
	 * a simple setter for the Receipt Service
	 * 
	 * @param receiptService the service to be set
	 */
	public void setReceiptService (ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	
	/**
	 * a GET route for image files associated with a receipt.
	 * 
	 * @param id the id of the receipt for which we want an image
	 * @return the image associated with the id provided
	 * 
	 * @throws UnavailableException thrown if no image exists. shouldn't happen.
	 * @throws IOException thrown in the event of an IO error.
	 */
	@RequestMapping(value="/getReceipt/image/{id}", method = RequestMethod.GET, produces = "image/jpeg")
	public @ResponseBody ResponseEntity<BufferedImage> getReceiptImage(@PathVariable Integer id) throws UnavailableException, IOException{
			
		// a byte array containing binary image data
		byte[] receiptImage = receiptService.getReceiptById(id).getImage();

		// on the (unlikely) event that that data is null, throw an exception
		if (receiptImage == null) {
	        throw new UnavailableException("The requested photo does not exist");
	    }
		
		// convert it to an input stream
		InputStream is = new ByteArrayInputStream(receiptImage);
		
		// set a contentType for the iterator we're about to use
	    MediaType contentType = MediaType.IMAGE_JPEG;
	    
	    // and a buffered image object to store that data in
	    BufferedImage body;
	    
	    // let's make that iterator
	    Iterator<ImageReader> imageReaders = ImageIO.getImageReadersByMIMEType(contentType.toString());
	    
	    // and iterate until we've got all our image data
	    if (imageReaders.hasNext()) {
	        ImageReader imageReader = imageReaders.next();
	        ImageReadParam irp = imageReader.getDefaultReadParam();
	        imageReader.setInput(new MemoryCacheImageInputStream(is), true);
	        body = imageReader.read(0, irp);
	    } else {
	        throw new HttpMessageNotReadableException("Could not find javax.imageio.ImageReader for Content-Type ["
	                + contentType + "]");
	    }
	    
	    /* and finally, we're ready to pass along the magic.
	     * note that we are only able to use the constructor without headers
	     * because of the annotation above. if using the code elsewhere, include
	     * said annotation (produces = "image/jpeg"), or response headers.
	     */
	    return new ResponseEntity<BufferedImage>(body, HttpStatus.OK);
		
	}
	
	/**
	 * This method provides a POST route to create new receipts. it's a dummy
	 * and needs fixing to be useful.
	 * 
	 * @param file this is the image file being uploaded
	 * @param request I'm not sure these are necessary. I'll check it.
	 * @param response
	 */
	@RequestMapping(value = "/addReceipt", method = RequestMethod.POST)
	public void addReceiptImage(@RequestParam("name") String receiptName, @RequestParam("lineItemId") Integer lineItemId, @RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			byte[] imageByteArray = file.getBytes();
			receiptService.sendReceiptData(imageByteArray, receiptName, lineItemId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method deletes receipts
	 */
	@RequestMapping(value = "/deleteReceipt/{id}", method = RequestMethod.GET)
	public void deleteReceipt(@PathVariable Integer id) {
		receiptService.delete(id);
	}
	
	/**
	 * this method provides an endpoint for our front-end to search and
	 * retrieve a list of lineitems, selected by the id of an associated
	 * lineitem
	 * 
	 * @param lineItemId the lineitem id to be searched for
	 * @return the associted list of receipts
	 */
	@RequestMapping(value= "/getReceipt/lineItem/{lineItemId}", method = RequestMethod.GET)
	public List<Receipt> getReceiptByLineItemId(@PathVariable Integer lineItemId) {
		return receiptService.getReceiptByLineItemId(lineItemId);
	}
	
	/**
	 * this method provides an endpoint for our frontend to retrieve a receipt
	 * selected by its unique id
	 * 
	 * @param id the id to be searched for
	 * @return the associated receipt
	 */
	@RequestMapping(value= "/getReceipt/{id}", method = RequestMethod.GET)
	public Receipt getReceiptById(@PathVariable Integer id) {
		return receiptService.getReceiptById(id);
	}
}
