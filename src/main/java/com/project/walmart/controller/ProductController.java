package com.project.walmart.controller;

import com.project.walmart.model.Product;
import com.project.walmart.payload.ProductDto;
import com.project.walmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @PostMapping("/create/{catid}")
    @ResponseBody
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product,@PathVariable int catid) {
        ProductDto createProduct = productService.createProduct(product,catid);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity<Page<ProductDto>> viewAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ProductDto> viewAll = productService.viewAll(page, size);
        return new ResponseEntity<>(viewAll, HttpStatus.OK);
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

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable int categoryId){
        List<Product> findByCategory = this.productService.findProductByCategory(categoryId);
      return new ResponseEntity<List<Product>>(findByCategory,HttpStatus.ACCEPTED);
    }


}
