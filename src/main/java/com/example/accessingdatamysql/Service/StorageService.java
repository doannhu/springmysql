package com.example.accessingdatamysql.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.accessingdatamysql.Entity.ImageData;
import com.example.accessingdatamysql.Repository.StorageRepository;
import com.example.accessingdatamysql.Util.ImageUtils;

@Service
public class StorageService {
    
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData =  storageRepository.save(ImageData.builder().name(file.getOriginalFilename())
                                                    .type(file.getContentType())
                                                    .imageData(ImageUtils.compressImage(file.getBytes()))
                                                    .build());
        if (imageData!=null) {
            return "file uploaded successfully" + file.getOriginalFilename();
        }

        return "unsuccessfully! ";
    }

    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
        return ImageUtils.decompressImage(dbImageData.get().getImageData());

    }

}
