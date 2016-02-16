package com.catalyst.springboot.dao;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Category;
import com.catalyst.springboot.entities.LineItem;

/**
 * 
 * @author mKness
 *
 */
public class CategoryDaoTest {

	private CategoryDao dao;
	private EntityManager mockEm;
	private Category category;
	
	@Before
	public void setup() {
		dao = new CategoryDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		category = mock(Category.class);
	}
	
	@Test
	public void getCategoriesTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);

		List<Category> expected = new ArrayList<Category>();

		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.getCategoies();

		verify(mockTypedQuery).getResultList();
	}
}
