package com.electronic.store.electronicstore.Repository;

import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Dtos.ProductDto;
import com.electronic.store.electronicstore.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //SEARCH

   Page<Product> findbytitleContaining(String Subtitle, Pageable pageable);

     Page<Product> findByLiveTrue(Pageable pageable);


}
