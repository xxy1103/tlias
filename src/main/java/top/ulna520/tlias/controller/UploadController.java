package top.ulna520.tlias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.ulna520.tlias.mapper.UserMapper;
import top.ulna520.tlias.model.Result;
import top.ulna520.tlias.service.UploadService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        uploadService.upload(image);
        return Result.success("Upload successful");
    }
}
