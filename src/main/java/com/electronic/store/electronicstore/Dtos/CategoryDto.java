package com.electronic.store.electronicstore.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto {



    private  String CategoryId;

    @NotBlank
    @Min(value = 4, message = "Title must be of minium 4 legnth ")
    private String title;

    @NotBlank(message = "description required")
    private String description;
    @NotBlank(message = "cover image required")
    private String coverImage;

}
