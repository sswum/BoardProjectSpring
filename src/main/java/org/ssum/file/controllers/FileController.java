package org.ssum.file.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ssum.file.entities.FileInfo;
import org.ssum.file.services.FileDeleteService;
import org.ssum.file.services.FileDownloadService;
import org.ssum.file.services.FileInfoService;
import org.ssum.file.services.FileUploadService;
import org.ssum.global.exceptions.RestExceptionProcessor;
import org.ssum.global.rests.JSONData;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController implements RestExceptionProcessor { //주로 자바스크립트로 처리 , implements RestExceptionProcessor 제이슨형태로 오류 나오게

    private final FileUploadService uploadService;
    private final FileDownloadService downloadService;
    private final FileInfoService infoService;
    private final FileDeleteService deleteService;


    @PostMapping("/upload")
    public ResponseEntity<JSONData> upload(@RequestPart("file") MultipartFile[] files,
                                           @RequestParam(name = "gid", required = false) String gid, @RequestParam(name = "location", required = false) String location) {


        List<FileInfo> items = uploadService.upload(files, gid, location);
        HttpStatus status = HttpStatus.CREATED;
        JSONData data = new JSONData(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);

    }

    @GetMapping("/download/{seq}")
    public void download(@PathVariable("seq") Long seq) {
        downloadService.download(seq);
    }

    @DeleteMapping("/delete/{seq}")
    public JSONData delete(@PathVariable("seq") Long seq) {
        FileInfo data = deleteService.delete(seq);

        return new JSONData(data);

    }
    //설명
    @DeleteMapping("/deletes/{gid}")
    public JSONData deletes(@PathVariable("gid")String gid, @RequestParam(name="location",required = false)String location) {
        List<FileInfo> items = deleteService.delete(gid, location);
        return new JSONData(items);

    }
     //파일 등록 번호를 가지고 파일 조회하기
    @GetMapping("/info/{seq}")
    public JSONData get(@PathVariable("seq")Long seq) {
        FileInfo data = infoService.get(seq);

        return new JSONData(data);
    }
    @GetMapping("/list/{gid}")
    public JSONData getList(@PathVariable("gid") String gid, @RequestParam(name="location", required = false) String location) {
        List<FileInfo> items = infoService.getList(gid, location);

        return new JSONData(items);
    }
}
