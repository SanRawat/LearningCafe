package com.cafebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOimpl implements CategoryDAO {
    @Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	/* */
	static {

		Category category = new Category();
		// adding first category

		category.setId(1);
		category.setName("Leafy");
		category.setDescription("have leafs only no fruits");
		category.setImageurl("CAT_1.png");
		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Beans");
		category.setDescription("Pulses type");
		category.setImageurl("CAT_2.png");
		categories.add(category);

		// adding 3rd category
		category = new Category();
		category.setId(3);
		category.setName("Juicy");
		category.setDescription("Juicy fruity type");
		category.setImageurl("CAT_3.png");
		categories.add(category);

	}

	@Override
	public List<Category> list() {

		
		 String selectActiveCategory = "FROM Category WHERE active = :active";
		  
		  Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		  
		  query.setParameter("active", true);
		  
		  return query.getResultList();
		 
		
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {

		/*for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}*/
	 return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	
	@Override
	public boolean update(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
