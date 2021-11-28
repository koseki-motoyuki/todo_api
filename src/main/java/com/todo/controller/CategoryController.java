package com.todo.controller;

import java.util.List;

import com.todo.dto.CategoryDto;
import com.todo.entity.Category;
import com.todo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

  @Autowired
  CategoryService categoryService;

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public List<CategoryDto> getCategoryList() {
    List<CategoryDto> categoryList = categoryService.getCategoryList();
    return categoryList;
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.POST)
  public Boolean saveCategory(@RequestBody Category category) {
    Boolean result = categoryService.saveCategory(category);
    return result;
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.PUT)
  public Boolean editCategory(@RequestBody Category category) {
    Boolean result = categoryService.editCategory(category);
    return result;
  }

  @ResponseBody
  @RequestMapping(path = "/{categoryId}", method = RequestMethod.DELETE)
  public Boolean deleteCategory(@PathVariable("categoryId") Integer categoryId) {
    Boolean result = categoryService.deleteCategory(categoryId);
    return result;
  }
}
