package com.todo.dao.mapper;

import java.util.List;

import com.todo.entity.Category;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
  List<Category> getCategoryList();

  Boolean saveCategory(Category category);

  Boolean editCategory(Category category);

  Boolean deleteCategory(Integer categoryId);

  Boolean deleteRelatedTasks(Integer categoryId);
}
