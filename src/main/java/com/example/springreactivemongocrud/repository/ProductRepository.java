package com.example.springreactivemongocrud.repository;

import com.example.springreactivemongocrud.dto.ProductDto;
import com.example.springreactivemongocrud.model.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

    Flux<ProductDto> findByPriceBetween(Range<Double> closed);
}
