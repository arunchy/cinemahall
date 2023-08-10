package com.example.cinemahallbackend.Controller;

import com.example.cinemahallbackend.Pojo.TempFile;
import com.example.cinemahallbackend.Repository.TempFileRepository;
import com.example.cinemahallbackend.Services.FileServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
public class ImageController {
    @Autowired
    private TempFileRepository tempFileRepository;
    @Autowired
    private FileServices fileServices;
    @Value("${project.image}")
    private String path;
    @CrossOrigin("http://localhost:3000/")
    @PostMapping("/upload_temp_img")
    public ResponseEntity<Object> uploadTempImage(@RequestParam("file")MultipartFile tempFile) throws IOException{
        String fileName= StringUtils.cleanPath(tempFile.getOriginalFilename());
        String uploadDir="./Images";
        File dirctory=new File(uploadDir);
        if(!dirctory.exists()){
            dirctory.mkdirs();
        }
        Path filepath=Path.of(uploadDir,fileName);
        Files.copy(tempFile.getInputStream(),filepath, StandardCopyOption.REPLACE_EXISTING);
        TempFile savedFile=new TempFile();
        savedFile.setFileName(fileName);
        TempFile savedEntity=tempFileRepository.save(savedFile);
        return ResponseEntity.ok(savedEntity);

    }
    @CrossOrigin("http://localhost:3000/")
    @GetMapping(value = "/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException{
        InputStream resource=this.fileServices.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        if(imageName.endsWith(".jpg")|| imageName.endsWith(".jpeg")){
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        }else if(imageName.endsWith(".png")){
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }else if(imageName.endsWith(".gif")){
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        }
        StreamUtils.copy(resource,response.getOutputStream());
    }


}
