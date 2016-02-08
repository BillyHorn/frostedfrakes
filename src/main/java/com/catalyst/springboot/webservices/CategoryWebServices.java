package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Category;
import com.catalyst.springboot.services.CategoryService;

@RestController
public class CategoryWebServices {

	
	@Autowired
	CategoryService categoryService;

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * 
	 * @return all the categories
	 */
	@RequestMapping(value="/categories", method=RequestMethod.GET) 
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
}
