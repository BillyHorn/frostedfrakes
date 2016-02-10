package com.catalyst.springboot.webservices;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catalyst.springboot.entities.Receipt;
import com.catalyst.springboot.services.ReceiptService;

@RestController
public class ReceiptWebService {
	
	@Autowired
	ReceiptService receiptService;
	
	public void setReceiptService (ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	
	@RequestMapping(value="/getReceipt", method = RequestMethod.GET, produces = "image/jpeg")
	public @ResponseBody ResponseEntity<BufferedImage> photo() throws Exception{
			
			byte[] receiptImage = receiptService.getReceipt().getImage();
			
			InputStream is = new ByteArrayInputStream(receiptImage);
	
			if (receiptImage == null) {
		        throw new UnavailableException("The requested photo does not exist");
		    }
			
			InputStream in = new ByteArrayInputStream(receiptImage);
			
		    MediaType contentType = MediaType.IMAGE_JPEG;
		    
		    Iterator<ImageReader> imageReaders = ImageIO.getImageReadersByMIMEType(contentType.toString());
		    
		    BufferedImage body;
			
		    if (imageReaders.hasNext()) {
		        ImageReader imageReader = imageReaders.next();
		        ImageReadParam irp = imageReader.getDefaultReadParam();
		        imageReader.setInput(new MemoryCacheImageInputStream(is), true);
		        body = imageReader.read(0, irp);
		    } else {
		        throw new HttpMessageNotReadableException("Could not find javax.imageio.ImageReader for Content-Type ["
		                + contentType + "]");
		    }
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);
		    return new ResponseEntity<BufferedImage>(body, headers, HttpStatus.OK);
		
	}
	
//	@RequestMapping(value="/getReceipt", method = RequestMethod.GET, produces = "image/jpeg")
//	public @ResponseBody byte[] getReceipt(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		try {
//			
//			byte[] receiptImage = receiptService.getReceipt().getImage();;
//	
//			InputStream in = new ByteArrayInputStream(receiptImage);
//			
//			BufferedImage image = ImageIO.read(in);
//			
//			ByteArrayOutputStream bao = new ByteArrayOutputStream();
//			
////			OutputStream out = response.getOutputStream();
//			
//			ImageIO.write(image, "jpeg", bao);
//			
//			return bao.toByteArray();
//		
//		} catch (IOException e) {
//			System.out.println(e);
//			throw new RuntimeException(e);
//		}
//	}
	
	@RequestMapping(value = "/addReceipt", method = RequestMethod.POST)
	public void addReceipt(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			byte[] imageByteArray = file.getBytes();
			receiptService.sendImage(imageByteArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
