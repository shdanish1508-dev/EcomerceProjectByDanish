package com.electronic.store.electronicstore.Controller;

import com.electronic.store.electronicstore.Dtos.ApiResponsemessage;
import com.electronic.store.electronicstore.Dtos.CategoryDto;
import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Entity.Category;
import com.electronic.store.electronicstore.Repository.CategoryRepository;
import com.electronic.store.electronicstore.Service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController
{
    // create
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto >createCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1= categoryService.create(categoryDto);

        return  new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    //update

    @PutMapping("/{categoryId}")
    public  ResponseEntity<CategoryDto> updateCategory(
            @PathVariable String categoryId,
            @RequestBody CategoryDto categoryDto)
    {

        CategoryDto updatedCategory= categoryService.update(categoryDto,categoryId);

      return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

    }

    //delete
    @DeleteMapping("/{categoryId}")
    public  ResponseEntity<ApiResponsemessage> deleteCategory(@PathVariable String categoryId)

    {
        categoryService.delete(categoryId);
       ApiResponsemessage responsemessage= ApiResponsemessage.builder().message("Category deleted successfully").status(HttpStatus.OK).success(true).build();

       return new ResponseEntity<>(responsemessage,HttpStatus.OK);
    }

    //get all

    @GetMapping
    public  ResponseEntity<PageableResponse<CategoryDto>> getAll(

            @RequestParam(value = "pageNumber", defaultValue = "0", required = false ) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "0", required = false ) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false ) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false ) String sortDir
            )
    {
        PageableResponse<CategoryDto>pageableResponse= categoryService.getAll(pageNumber,pageSize, sortBy, sortDir );

    return new ResponseEntity<>(pageableResponse,HttpStatus.OK);
    }

    // get single
    @GetMapping("/categoryId")
    public ResponseEntity<CategoryDto>getSingle(@PathVariable String categoryId)
    {
       CategoryDto categoryDto= categoryService.get(categoryId);
       return new ResponseEntity.ok(categoryId);

    }



}
