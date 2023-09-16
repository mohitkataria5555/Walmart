package com.project.walmart.service;


import com.project.walmart.Exception.ResourceNotFoundException;
import com.project.walmart.model.Category;
import com.project.walmart.payload.CategoryDto;
import com.project.walmart.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto createCategory(CategoryDto categoryDto){
        Category cat=this.modelMapper.map(categoryDto,Category.class);
        Category save=this.categoryRepository.save(cat);
        return  this.modelMapper.map(save,CategoryDto.class);
    }

    public List<CategoryDto> viewAll(){

        return null;
    }

    public CategoryDto viewCategoryById(int cid){
        Category getById=this.categoryRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category id Not Found."));

        return this.modelMapper.map(getById,CategoryDto.class);
    }

    public void deleteCategory(int cid){
        Category Cat=this.categoryRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category id Not Found."));
        this.categoryRepository.delete(Cat);

    }

    public CategoryDto updateCategory(int cid, CategoryDto newc){
        Category oldCat=this.categoryRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category id Not Found."));
        oldCat.setCategory_id(newc.getCategory_id());
        oldCat.setTitle(newc.getTitle());

        return this.modelMapper.map(oldCat,CategoryDto.class);

    }


}
