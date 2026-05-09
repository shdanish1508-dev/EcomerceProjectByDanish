package com.electronic.store.electronicstore.Service.Impl;

import com.electronic.store.electronicstore.Dtos.UserDto;
import com.electronic.store.electronicstore.Entity.User;
import com.electronic.store.electronicstore.Exception.ResourceNotfoundException;
import com.electronic.store.electronicstore.Repository.UserRepository;
import com.electronic.store.electronicstore.Service.UserService;
import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PageableArgumentResolver pageableArgumentResolver;

    @Override
    public UserDto createUser(UserDto userDto) {


        String userId= UUID.randomUUID().toString();
        userDto.setUserId(userId);
     User user = dtoToEntity(userDto);
     User savedUser= userRepository.save(user);

     UserDto newDto= entityToDto(savedUser);



      return newDto;
    }




    @Override
//    public UserDto updateUser(UserDto userDto, String userId) {
//
//     User user=  userRepository.findById(userId).orElseThrow(()-> new  RuntimeException("User Not found expection"));
//
//
//
//        user.setName(userDto.getName());
//       user.setEmail(userDto.getEmail());
//       user.setAbout(userDto.getAbout());
//       user.setGender(userDto.getGender());
//
//      User updatedUser= userRepository.save(user);
//      User updatedDto=  entityToDto(updatedUser);
//
//
//        return updatedDto;
//    }



    public UserDto updateUser(UserDto userDto, String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());

        User updatedUser = userRepository.save(user);

        UserDto updatedDto = entityToDto(updatedUser);

        return updatedDto;
    }

    @Override
    public void deleteUser(String userId) {

        User user=  userRepository.findById(userId).orElseThrow(()-> new ResourceNotfoundException("User Not found expection"));

        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers( int  pageNumber,int PageSize) {

        Sort sort= Sort.By(sortBy);

        Pageable pageable= PageRequest.of(pageNumber,PageSize,sort);

         Page<User> page = userRepository.findAll(pageable);
            List<User>users=  page.getContent();


      List<UserDto>dtoList=  users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {


        User user=  userRepository.findById(userId).orElseThrow(()->new ResourceNotfoundException("user not  found with given id"));


        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {


      User user=   userRepository.findByEmail(email).orElseThrow(()->new ResourceNotfoundException("user not  found with email"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {


      List<User>users=  userRepository.findByNameContaining(keyword);

        List<UserDto>dtoList=  users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }



    private UserDto entityToDto(User savedUser)
    {

//       UserDto userDto= UserDto.builder()
//                .userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .about(savedUser.getAbout())
//                .imageName(savedUser.getImageName())
//                .build();


       return modelMapper.map(savedUser,UserDto.class);


    }

    private User dtoToEntity(UserDto userDto)
    {

//
//        User user =User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .imageName(userDto.getImageName())
//                .build();

        return modelMapper.map(userDto, User.class);

    }


}
