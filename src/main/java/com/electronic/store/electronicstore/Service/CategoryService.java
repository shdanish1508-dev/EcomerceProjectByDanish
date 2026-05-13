package com.electronic.store.electronicstore.Service;

import com.electronic.store.electronicstore.Dtos.CategoryDto;
import com.electronic.store.electronicstore.Dtos.PageableResponse;
import org.springframework.data.domain.Pageable;

public interface CategoryService {


    //create

    CategoryDto create(CategoryDto categoryDto);
    //update

    CategoryDto update(CategoryDto categoryDto , String categoryId);
    //delete

    void delete(String categoryId);
    //get single all

    PageableResponse<CategoryDto> getAll(Pageable pageable);

    // get single Category

    CategoryDto get(String categoryId);

    //search


}
