package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Category;
import com.catalyst.springboot.services.CategoryService;

/**
 * 
 * @author mKness
 *
 */
public class CategoryWebServicesTest {

	private CategoryWebServices categoryWebServices;
	private CategoryService categoryService;
	private Category category;
	
	@Before
	public void setup() {
		categoryWebServices = new CategoryWebServices();
		categoryService = mock(CategoryService.class);
		categoryWebServices.setCategoryService(categoryService);
		category = mock(Category.class);
	}
	
	@Test
	public void getCategoriesTest() {
		List<Category> categories = new ArrayList<Category>();
		
		when(categoryWebServices.getCategories()).thenReturn(categories);
		
		categoryWebServices.getCategories();
		verify(categoryService).getCategories();
	}
}
