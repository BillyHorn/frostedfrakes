package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.CategoryDao;
import com.catalyst.springboot.entities.Category;

/**
 * contains services related to dao for categories
 * @author mkness
 *
 */
@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	/**
	 * 
	 * @return all categories
	 */
	public List<Category> getCategories() {
		return categoryDao.getCategoies();
	}

}
