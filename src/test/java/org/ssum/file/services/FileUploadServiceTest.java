package org.ssum.file.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;
import org.ssum.file.entities.FileInfo;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService uploadService;


    @Test
    void uploadTest() {
    //mock multipart file 매개변수로 쓸 예정
        MockMultipartFile file1 = new MockMultipartFile("file", "test1.png", "images/png", "ABC".getBytes());

        MockMultipartFile file2 = new MockMultipartFile("file", "test2.png", "images/png", "DEF".getBytes());

       List<FileInfo> items=  uploadService.upload(new MultipartFile[]{file1, file2}, "testgid", "testlocation");

       items.forEach(System.out::println);
    }
}
