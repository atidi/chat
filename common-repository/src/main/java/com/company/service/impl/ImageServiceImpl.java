package com.company.service.impl;

import com.company.exception.ImageStoreException;
import com.company.service.ImageService;
import com.company.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${app.upload.path}")
    public String uploadDir;

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            return FileUtils.storeImage(file,uploadDir);
        } catch (Exception e) {
            throw new ImageStoreException(String.format("Could not store image %s.", file.getOriginalFilename()),e);
        }
    }
}
