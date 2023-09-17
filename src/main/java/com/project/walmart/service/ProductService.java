package com.project.walmart.service;

import com.project.walmart.Exception.ResourceNotFoundException;
import com.project.walmart.model.Category;
import com.project.walmart.model.Product;
import com.project.walmart.payload.ProductDto;
import com.project.walmart.repository.CategoryRepository;
import com.project.walmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDto createProduct(ProductDto product,int catid){
        //fetch category is available or not
        Category category=this.categoryRepository.findById(catid).orElseThrow(()->new ResourceNotFoundException("Category doesn't exists"));
        //ProductDto to Product
        Product product1=toEntity(product);
        product1.setCategory(category);
        Product save=this.productRepository.save(product1);


        //Product save =productRepository.save(entity);
        //product to productDto
        ProductDto dto = toDto(save);

        return dto;
    }
    public List<ProductDto> viewAll(){
        //ProductDto to Product
       List<Product> findAll = productRepository.findAll();
       //Product to productDto
        List<ProductDto>  findAllDto = findAll.stream().map(product -> this.toDto(product)).collect(Collectors.toList());
       return findAllDto;
    }
    public ProductDto viewProductById(int pid){
        //ProductDto  to  product
        Product findById= productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"product not found for this product id"));
        //product to productDto
        ProductDto findByIdDto=this.toDto(findById);
        return findByIdDto;
    }

    public void deleteProduct(int pid){
        Product byId=productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"product not found for this product Id"));
        productRepository.delete(byId);

    }

    public ProductDto updateProduct(int pid, ProductDto newp){
        Product oldp=productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"product not found for this product id"));
        oldp.setProduct_name(newp.getProduct_name());
        oldp.setLive(newp.isLive());
        oldp.setStock(newp.isStock());
        oldp.setProduct_price(newp.getProduct_price());
        oldp.setProduct_desc(newp.getProduct_desc());
        oldp.setProduct_Image(newp.getProduct_Image());
        oldp.setProduct_quantity(newp.getProduct_quantity());
        Product save=productRepository.save(oldp);
        ProductDto dto=toDto(save);

        return dto;

    }
//ProductDto to Product
    public Product toEntity(ProductDto productDto){
        Product p = new Product();
        p.setProduct_id(productDto.getProduct_id());
        p.setProduct_name(productDto.getProduct_name());
        p.setProduct_desc(productDto.getProduct_desc());
        p.setProduct_price(productDto.getProduct_price());
        p.setProduct_Image(productDto.getProduct_Image());
        p.setLive(productDto.isLive());
        p.setStock(productDto.isStock());
        return p;
    }

    //Product to productdto
    public ProductDto toDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setProduct_desc(product.getProduct_desc());
        productDto.setProduct_price(product.getProduct_price());
        productDto.setProduct_Image(product.getProduct_Image());
        productDto.setLive(product.isLive());
        productDto.setStock(product.isStock());

        return productDto;
    }
}
