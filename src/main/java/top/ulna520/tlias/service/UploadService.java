package top.ulna520.tlias.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.ulna520.tlias.model.Result;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class UploadService {

    public void upload(MultipartFile images) throws Exception{
        String originalFilename = images.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID() + extname;
        Path dirPath = Paths.get("src/main/resources/static/images/" + datePath);
        Path filePath = dirPath.resolve(newFileName);
        // 创建文件夹（如果不存在）
        java.nio.file.Files.createDirectories(dirPath);
        images.transferTo(filePath);
    }
}

