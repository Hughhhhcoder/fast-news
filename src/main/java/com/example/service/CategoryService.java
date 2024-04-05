package com.example.service;

import com.example.pojo.Category;

import java.util.List;

public interface CategoryService {


    Category findById(Integer id);

    void add(Category category);

    List<Category> list();

    void update(Category category);
}
