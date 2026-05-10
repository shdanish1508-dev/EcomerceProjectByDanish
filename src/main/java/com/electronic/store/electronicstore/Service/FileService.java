package com.electronic.store.electronicstore.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public interface FileService {

     String uploadFile(MultipartFile file,String path);

     InputStream getResource(String path,String fileName);


}
