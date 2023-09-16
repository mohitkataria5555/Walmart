package com.project.walmart.controller;

import com.project.walmart.payload.ApiResponse;
import com.project.walmart.payload.CategoryDto;
import com.project.walmart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
        CategoryDto create=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(create, HttpStatus.CREATED);
    }

    @PutMapping("/update/{categoryId}")
    @ResponseBody
    public ResponseEntity<CategoryDto> update(@PathVariable int categoryId,@RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryId,categoryDto);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{categoryId}")
    public  ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/view/{categoryId}")
    public ResponseEntity<CategoryDto> viewCategoryById(@PathVariable int categoryId){
        CategoryDto viewCategoryById=this.categoryService.viewCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(viewCategoryById,HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<List<CategoryDto>> viewAllCategory(){
        List<CategoryDto> viewAll=this.categoryService.viewAll();
        return  new ResponseEntity<List<CategoryDto>>(viewAll,HttpStatus.ACCEPTED);
    }



}
