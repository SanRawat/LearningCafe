package com.cafebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.cafebackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	 
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Summer Delicious");
		category.setDescription("This is some description for Summer Delicious!");
		category.setImageurl("CAT_107.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));	
	}
	
	/*@Test
	public void testGetCategory() {
		
		category = new Category();
		
		category= categoryDao.get(1);
		
		assertEquals("Successfully fetched a category from  the table!","Spring Fresh",category.getName());
	}
	*/
	/*@Test
	public void testUpdateCategory() {
		
		category = new Category();
		category= categoryDao.get(1);
		category.setName("WinterTaste");
		category.setDescription("This is some description for Winter Fresh!");
		
		
		assertEquals("Successfully updated a single category inside the table!",true,categoryDao.update(category));
		
		
	}
	*/
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDao.get(1);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDao.delete(category));
		
		
	}*/
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully get list of categories from the table!",3,categoryDao.list().size());
		
		
	}
	*/
	/*@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Make Dry");
		category.setDescription("This is some description for make Dry!");
		category.setImageurl("CAT_3.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		
		category = new Category();
		
		category.setName("Eat Raw");
		category.setDescription("This is some description for Eat Raw!");
		category.setImageurl("CAT_4.png");
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));

		
		// fetching and updating the category
		category = categoryDao.get(6);
		
		category.setName("SummerD");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDao.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDao.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",5,categoryDao.list().size());		
				
		
	}
	*/
	
	
}
