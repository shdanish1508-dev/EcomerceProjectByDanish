package com.electronic.store.electronicstore.Dtos;

import lombok.*;
import org.springframework.http.HttpStatus;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ImageResponse {
//
//    private String ImageName;
//
//    private String Message;
//    private boolean success;
//    private HttpStatus status;
//
//
//}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResponse {

    private String imageName;
    private String message;
    private boolean success;
    private HttpStatus status;
}