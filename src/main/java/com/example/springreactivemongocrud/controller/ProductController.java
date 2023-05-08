package com.example.springreactivemongocrud.controller;


import com.example.springreactivemongocrud.dto.ProductDto;
import com.example.springreactivemongocrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public Flux<ProductDto> getproducts(){
        return productService.getProducts();
    }

    @GetMapping(value = "/product/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping(value = "/productInRange")
    public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max){
        return productService.getProductInRange(min,max);
    }

    @PostMapping(value = "/saveProducts")
    public Mono<ProductDto> saveProduct(@RequestBody  Mono<ProductDto> productDtoMono){
        return productService.saveProduct(productDtoMono);
    }

    @GetMapping(value = "/updateProducts")
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono){
        return productService.updateProduct(productDtoMono);
    }

    @GetMapping(value = "/deleteProducts")
    public Mono<Void> deleteProduct(@RequestParam String id){
        return productService.deleteProduct(id);
    }

}
