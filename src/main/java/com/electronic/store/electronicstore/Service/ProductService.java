package com.electronic.store.electronicstore.Service;

import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Dtos.ProductDto;

import java.util.List;

public interface ProductService {

    //create

    ProductDto create(ProductDto productDto);

    //update
    ProductDto update(ProductDto productDto, String productId);


    //delete
    void delete(String productId);

    //get single
    ProductDto get(String productId);

    //get Allproduct
    PageableResponse<ProductDto> getAll(int pagenumber, int pagesize, String SortBy, String sortDir);

    //get all product Live

    PageableResponse<ProductDto>getAllLive(int pagenumber, int pagesize, String SortBy, String sortDir);

   PageableResponse<ProductDto>searchByTitle(int pagenumber, int pagesize, String SortBy, String sortDir);




    //search product
}
