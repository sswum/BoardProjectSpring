package org.ssum.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.ssum.file.entities.FileInfo;
import org.ssum.file.repositories.FileInfoRepository;
import org.ssum.global.configs.FileProperties;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableConfigurationProperties(FileProperties.class)
@RequiredArgsConstructor
@Service
public class FileUploadService {

    private final FileInfoRepository fileInfoRepository;
    private final FileProperties properties;
    private final FileInfoService fileInfoService;

    public List<FileInfo> upload(MultipartFile[] files, String gid, String location) {
        /**
         * 1. 파일 정보 저장
         * 2. 파일을 서버로 이동
         * 3. 이미지이면 썸네일 생성
         */
        gid = StringUtils.hasText(gid) ? gid : UUID.randomUUID().toString();

        List<FileInfo> uploadedFiles = new ArrayList<>();

        //1. 파일 정보 저장
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename(); //업로드 파일 원래 이름
            String contentType = file.getContentType(); //파일 형식
            String extension = fileName.substring(fileName.lastIndexOf("."));

            FileInfo fileInfo = FileInfo.builder()
                    .gid(gid)
                    .location(location)
                    .fileName(fileName)
                    .extension(extension)
                    .contentType(contentType)
                    .build();

            fileInfoRepository.saveAndFlush(fileInfo);

            // 분산해서 파일을 저장하도록 설정
            //2. 파일을 서버로 이동
            long seq = fileInfo.getSeq();
            String uploadDir = properties.getPath()+ "/" +(seq % 10L); // 한번에 여러개 하면 서버 부하가 오니까 열개씩 나눠서 할 수 있도록 값 설정
            File dir = new File(uploadDir);
            if (!dir.exists() || !dir.isDirectory()) { //파일이 존재하지 않거나 디렉토리에 없으면 생성하도록
                dir.mkdir(); // 폴더1번에 1.png , 폴더2번에 2.png 생성 이렇게 그다음엔 3번이 되겠쥬?
            }
            String uploadPath = uploadDir + "/" + seq + extension;
            try {
                file.transferTo(new File(uploadPath));

                uploadedFiles.add(fileInfo);

            } catch (IOException e) {
                e.printStackTrace();
                //파일 이동 실패 시 정보 삭제
                fileInfoRepository.delete(fileInfo);
                fileInfoRepository.flush();
            }

        }
        uploadedFiles.forEach(fileInfoService::addFileInfo);
        return uploadedFiles;
    }
}


