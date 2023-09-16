package com.project.walmart.controller;

import com.project.walmart.model.Product;
import com.project.walmart.payload.ProductDto;
import com.project.walmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        ProductDto createProduct = productService.createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity<List<ProductDto>> viewAllProduct(){
        List<ProductDto> viewAll =productService.viewAll();
        return  new ResponseEntity<List<ProductDto>>(viewAll,HttpStatus.ACCEPTED);
    }
    @GetMapping("/view/{productId}")
    public ResponseEntity<ProductDto> viewProductById(@PathVariable int productId){
        ProductDto viewProductById=productService.viewProductById(productId);
        return new ResponseEntity<ProductDto>(viewProductById,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{productId}")
    public  ResponseEntity<String> deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public  ResponseEntity<ProductDto> updateProduct(@PathVariable int productId,@RequestBody ProductDto newproduct){
        ProductDto updatedProduct=productService.updateProduct(productId, newproduct);
        return new ResponseEntity<ProductDto>(updatedProduct,HttpStatus.ACCEPTED);
    }


}
