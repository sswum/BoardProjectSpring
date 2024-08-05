package org.ssum.file.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ssum.file.entities.FileInfo;
import org.ssum.file.services.FileUploadService;
import org.ssum.global.exceptions.RestExceptionProcessor;
import org.ssum.global.rests.JSONData;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController implements RestExceptionProcessor { //주로 자바스크립트로 처리 , implements RestExceptionProcessor 제이슨형태로 오류 나오게

    private final FileUploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<JSONData> upload(@RequestPart("file") MultipartFile[] files,
                                           @RequestParam(name = "gid", required = false) String gid, @RequestParam(name = "location", required = false) String location) {


        List<FileInfo> items = uploadService.upload(files, gid, location);
        HttpStatus status = HttpStatus.CREATED;
        JSONData data = new JSONData(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);

    }
}
