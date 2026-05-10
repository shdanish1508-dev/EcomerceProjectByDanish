package com.electronic.store.electronicstore.Exception;

public class BadApiRequest extends RuntimeException

{
    public BadApiRequest(String message)
    {
        super(message);
    }
    public BadApiRequest()
    {
        super("Bad Request");
    }
}

