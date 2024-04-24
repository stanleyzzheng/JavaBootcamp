package stanford.capstone.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import stanford.capstone.Exceptions.FileStorageException;
import stanford.capstone.service.FileStorageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileStorageServiceImpl implements FileStorageService {
    private static final String FILE_STORAGE_LOCATION  = "C:\\Users\\Stanl\\IdeaProjects\\Java_Bootcamp\\Uploads";
    @Override
    public String storeFile(MultipartFile file) {
        try{
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(FILE_STORAGE_LOCATION + fileName);

            Files.copy(file.getInputStream(), filePath);
            return fileName;
        }catch(IOException ex){
            throw new FileStorageException("Failed to store file " + file.getOriginalFilename());
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try{
            Path filePath = Paths.get(FILE_STORAGE_LOCATION).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) return  resource;
            else{
                throw new FileStorageException("File not found: " + fileName);
            }
        }catch (MalformedURLException ex){
            throw new FileStorageException("File not found: " + fileName);
        }
    }
}
