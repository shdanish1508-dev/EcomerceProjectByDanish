package com.electronic.store.electronicstore.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Category
{
    @Id

    private  String CategoryId;
    @Column(name="category_title", length=100 ,nullable=false)
    private String title;
    @Column(name = "category_desc", length=500)
    private String description;
    private String coverImage;



}
