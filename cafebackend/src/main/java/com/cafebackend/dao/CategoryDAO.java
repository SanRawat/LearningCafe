package com.cafebackend.dao;

import java.util.List;

import com.cafebackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
