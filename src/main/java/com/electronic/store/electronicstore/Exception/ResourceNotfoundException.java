package com.electronic.store.electronicstore.Exception;

import lombok.Builder;

public class ResourceNotfoundException  extends RuntimeException{

    @Builder
    public ResourceNotfoundException()
    {
        super("Resource Not Found");
    }

    public ResourceNotfoundException(String message)
    {
        super(message);
    }

}
