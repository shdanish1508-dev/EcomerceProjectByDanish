package com.electronic.store.electronicstore.Dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponsemessage {

    private String message;
    private boolean success;
    private HttpStatus status;
}
