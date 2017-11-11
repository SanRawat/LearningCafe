package com.cafebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cafebackend.dao.CategoryDAO;
import com.cafebackend.dto.Category;

@Repository("categoryDao")
public class CategoryDAOimpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

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
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for(Category category: categories) {
			if(category.getId() ==id)  return category;
		}
		return null;
	}

}
