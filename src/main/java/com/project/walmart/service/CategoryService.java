package com.project.walmart.service;


import com.project.walmart.model.Category;
import com.project.walmart.payload.CategoryDto;
import com.project.walmart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto createCategory(CategoryDto categoryDto){

        return  null;
    }

    public List<CategoryDto> viewAll(){

        return null;
    }

    public CategoryDto viewCategoryById(int cid){

        return null;
    }

    public void deleteCategory(int cid){


    }

    public CategoryDto updateCategory(int cid, CategoryDto newc){


        return null;

    }


    public Category toEntity(CategoryDto categoryDto){
        Category c = new Category();
        c.setTitle(categoryDto.getTitle());
        return c;
    }


    public CategoryDto toDto(Category category){
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setTitle(category.getTitle());

        return categoryDto;
    }

}
