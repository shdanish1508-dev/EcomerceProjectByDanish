package com.electronic.store.electronicstore.Service.Impl;

import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Dtos.ProductDto;
import com.electronic.store.electronicstore.Entity.Product;
import com.electronic.store.electronicstore.Exception.ResourceNotfoundException;
import com.electronic.store.electronicstore.Helper.Helper;
import com.electronic.store.electronicstore.Repository.ProductRepository;
import com.electronic.store.electronicstore.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class     ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public ProductDto create(ProductDto productDto) {


        Product product = mapper.map(productDto, Product.class);

     Product savedProduct=   productRepository.save(product);
        return mapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto, String productId) {

       Product product= productRepository.findById(productId).OrElseThrow(()-> new ResourceNotfoundException("Product not found of given Id"));

      product.setTitle(productDto.getTitle());
       product.setDescription(productDto.getDescription());
       product.setPrice(productDto.getPrice());
       product.setPrice(productDto.getPrice());
       product.setDiscountedPrice(productDto.getDiscountedPrice);
       product.setQuantity(productDto.getQuantity());
       product.setAddedDate(productDto.getAddedDate());
       product.setLive(productDto.isLive());
       product.setStock(productDto.isStock());

        Product updatedProduct= productRepository.save(product);

        return null;
    }

    @Override
    public void delete(String productId) {

        Product product= productRepository.findById(productId).OrElseThrow(()-> new ResourceNotfoundException("Product not found of given Id"));

        productRepository.delete(product);


    }

    @Override
    public ProductDto get(String productId) {

        Product product= productRepository.findById(productId).OrElseThrow(()-> new ResourceNotfoundException("Product not found of given Id"));

        return  mapper.map(product, ProductDto.class);
    }

    @Override
    public PageableResponse<ProductDto> getAll(int pagenumber, int pagesize, String SortBy, String sortDir) {


//        Sort sort= Sort.by(Sort.Direction.ASC,"price");

        Sort sort= (sortDir.equalsIgnoreCase("desc")?(Sort.by(sortBy   ).descending())): ((Sort.by(sortBy).acscending;))

        Pageable pageable= PageRequest.of(pagenumber,pagesize,sort);

       Page<Product>page= productRepository.findAll(pageable);
        return Helper.getPageableResponse(page,ProductDto.class);
    }

    @Override
    public PageableResponse<ProductDto>getAllLive(int pagenumber, int pagesize, String SortBy, String sortDir) {


        Sort sort= (sortDir.equalsIgnoreCase("desc")?(Sort.by(sortBy   ).descending())): ((Sort.by(sortBy).acscending;))

        Pageable pageable= PageRequest.of(pagenumber,pagesize,sort);

        Page<Product>page= productRepository.findByLiveTrue(pageable);
        return Helper.getPageableResponse(page,ProductDto.class);
    }
    }

    @Override
    public PageableResponse<ProductDto>searchByTitle(int pagenumber, int pagesize, String SortBy, String sortDir) {
        Sort sort= (sortDir.equalsIgnoreCase("desc")?(Sort.by(sortBy   ).descending())): ((Sort.by(sortBy).acscending;))

        Pageable pageable= PageRequest.of(pagenumber,pagesize,sort);

        Page<Product>page= productRepository.findByTitlecontaining (pageable);
        return Helper.getPageableResponse(page,ProductDto.class);
    }
}

