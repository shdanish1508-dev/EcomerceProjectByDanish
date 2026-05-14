package com.electronic.store.electronicstore.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerators;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {



    private String productID;
    private String  title;

    private String description;
    private int price;
    private int quantity;
    private Date addedDate;
    private boolean live;
}
