package com.electronic.store.electronicstore.Service;

import com.electronic.store.electronicstore.Dtos.UserDto;
import com.electronic.store.electronicstore.Entity.User;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto userDtos);

    UserDto updateUser  (UserDto userDto, String userId );

    void deleteUser(String userId);

    List<UserDto> getAllUsers(int pageNumber, int pageSize, String sortBy, String sortDir);

    UserDto getUserById(String userId);

    UserDto getUserByEmail(String email);

    List<UserDto> searchUser(String keyword);
}
