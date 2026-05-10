package com.electronic.store.electronicstore.Dtos;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse<T> {

    private List<T>content;
    private  int pageNumber;
    private  int pageSize;
    private  long totalElements;
    private int totalPages;
    private boolean lastpage;


}
