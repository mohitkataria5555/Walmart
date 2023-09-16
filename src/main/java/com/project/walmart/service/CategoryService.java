package com.project.walmart.service;


import com.project.walmart.Exception.ResourceNotFoundException;
import com.project.walmart.model.Category;
import com.project.walmart.payload.CategoryDto;
import com.project.walmart.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



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
        List<Category> findall=this.categoryRepository.findAll();
        List<CategoryDto> allDto =findall.stream().map(category -> this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());

        return allDto;
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

        oldCat.setTitle(newc.getTitle());
        Category save= this.categoryRepository.save(oldCat);

        return this.modelMapper.map(save,CategoryDto.class);

    }


}
