package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.todo.dao.mapper.CategoryMapper;
import com.todo.dto.CategoryDto;
import com.todo.entity.Category;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  CategoryMapper categoryMapper;

  public List<CategoryDto> getCategoryList() {
    List<CategoryDto> categoryListDto = new ArrayList<CategoryDto>();
    List<Category> categoryListEntity = categoryMapper.getCategoryList();
    for (Category categoryEntity : categoryListEntity) {
      CategoryDto categoryDto = new CategoryDto();
      BeanUtils.copyProperties(categoryEntity, categoryDto);
      categoryListDto.add(categoryDto);
    }
    return categoryListDto;
  }

  public Boolean saveCategory(Category category) {
    Boolean result = categoryMapper.saveCategory(category);
    return result;
  }

  public Boolean editCategory(Category category) {
    Boolean result = categoryMapper.editCategory(category);
    return result;
  }

  public Boolean deleteCategory(Integer categoryId) {
    Boolean result = categoryMapper.deleteCategory(categoryId);
    if (result) {
      categoryMapper.deleteRelatedTasks(categoryId);
    }
    return result;
  }
}
