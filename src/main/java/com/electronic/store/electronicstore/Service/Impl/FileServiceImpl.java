package com.electronic.store.electronicstore.Service.Impl;

import com.electronic.store.electronicstore.Exception.BadApiRequest;
import com.electronic.store.electronicstore.Service.FileService;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadFile(MultipartFile file, String path) {

        String originalFilename = file.getOriginalFilename();

        logger.info("filename :{}", originalFilename);

        String filename= UUID.randomUUID().toString();

        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileNameWithExtension= filename +  extension;

        String fullpathwithFileName= path+ File.separator+fileNameWithExtension;

        if(extension.equalsIgnoreCase(".png"))|| extension.equalsIgnoreCase(".jpg")|| extension.equalsIgnoreCase(".jpeg");
        {

            File folder =new File(path);

            if(!folder.exists())
            {
                folder.mkdirs();

            }

            File.copy(file.getInputStream(),Path.get(fullpathwithFileName));

            return fileNameWithExtension;
        }
        else{
                    throw new BadApiRequest("File with this"+extension+" extension is not supported");
        }

        return "";
    }

    @Override
    public InputStream getResource(String path, String fileName) {


        String fullpath=path+File.separator+fileName;
        InputStream inputStream= new FileInputStream(fullpath);
        return inputStream;
    }
}
