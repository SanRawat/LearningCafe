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
	 
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Roots");
		category.setDescription("Root type");
		category.setImageurl("CAT_3.png");
		
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));	
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = new Category();
		
		category= categoryDAO.get(3);
		
		assertEquals("Successfully fetched a category from  the table!","Roots",category.getName());
	}
	*/
	/*@Test 
	public void testUpdateCategory() {
		
		category = new Category();
		category= categoryDAO.get(1);
		category.setName("WinterTaste");
		category.setDescription("This is some description for Winter Fresh!");
		
		
		assertEquals("Successfully updated a single category inside the table!",true,categoryDAO.update(category));
		
		
	}*/
	
    /*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(1);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}*/
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully get list of categories from the table!",2,categoryDAO.list().size());
		
		
	}
	*/
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Boom");
		category.setDescription("This is some description for make Dry!");
		category.setImageurl("CAT_3.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Healthy");
		category.setDescription("This is some description for Eat Raw!");
		category.setImageurl("CAT_4.png");
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(5);
		
		category.setName("SummerD");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
	     category = categoryDAO.get(7);	
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",5,categoryDAO.list().size());		
				
		
	}
	
	
	
}
