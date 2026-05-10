package com.electronic.store.electronicstore.Helper;

import com.electronic.store.electronicstore.Dtos.PageableResponse;
import com.electronic.store.electronicstore.Dtos.UserDto;
import com.electronic.store.electronicstore.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static<U,V>PageableResponse<V> getPageResponse(Page<U> page,Class<V> type)
    {

        List<U> entity=  page.getContent();

        List<UserDto>dtoList =  entity.stream().map(object -> new ModelMapper().map(object,type).toList());


        PageableResponse<V> response= new PageableResponse<>( );
        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setPageNumber(page.getNumber);
        response.setTotalElements(page.getTotalElements);
        response.setTotalPages(page.getTotalPage);
        response.setLastpage(page.isLast());

        return response;

    }
}
