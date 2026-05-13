package com.electronic.store.electronicstore.Service.Impl;

import com.electronic.store.electronicstore.Dtos.CategoryDto;
import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Entity.Category;
import com.electronic.store.electronicstore.Exception.ResourceNotfoundException;
import com.electronic.store.electronicstore.Helper.Helper;
import com.electronic.store.electronicstore.Repository.CategoryRepository;
import com.electronic.store.electronicstore.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

@Autowired
    private CategoryRepository categoryRepository;

@Autowired
private ModelMapper modelMapper;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {

     Category category= modelMapper.map( categoryDto, CategoryDto.class );
      Category savedCategory = CategoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {

     Category category=   categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotfoundException("Category not found exception"));

             //update Category dto

        category.setTitle(categoryDto.getTitle());
         category.setDescription(categoryDto.getDescription());
         category.setCoverImage(categoryDto.getCoverImage());
        Category updatedCategory= categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {

        Category category=   categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotfoundException("Category not found exception"));

        CategoryRepository.delete(category);
    }

    @Override
    public PageableResponse<CategoryDto> getAll( int pageNumber, int pageSize,String sortBy , String sortDir)
    {
        Sort sort= (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()): (Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber,pageSize, sort);
        Page<Category> page= categoryRepository.findAll(pageable);
        Helper.getPageResponse(page,CategoryDto.class);

        categoryRepository.findAll(pageable);
        return pageableResponse;
    }

    @Override
    public CategoryDto get(String categoryId)
    {
        Category category=categoryRepository.findById(categoryId).orElseThrow();
        return modelMapper.map(category, CategoryDto.class);

    }
}
