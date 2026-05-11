package com.electronic.store.electronicstore.Entity;


import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name="user_name")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String  userId;
//
//    @Column(name="user_name")
//    private  String name;
//    @Column(name = "user_email", unique = true)
//    private String email;
//    @Column(name="user_password", length = 10, nullable = false)
//    private String password;
//    private String gender;
//    @Column(length=1000)
//    private String about;
//
//    @Column(name="user_image_name")
//    private  String imageName;
//
//}

//public class User {
//
//    @Id
//    private String userId;
//
//    @Column(name="user_name")
//    private String name;
//
//    @Column(name = "user_email", unique = true)
//    private String email;
//
//    @Column(name="user_password", nullable = false, length = 100)
//    private String password;
//
//    private String gender;
//
//    @Column(length=1000)
//    private String about;
//
//    @Column(name="user_image_name")
//    private String imageName;
//}

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    private String gender;

    @Column(length = 1000)
    private String about;

    @Column(name = "user_image_name")
    private String imageName;
}
