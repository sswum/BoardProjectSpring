package org.ssum.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ssum.file.contants.FileStatus;
import org.ssum.file.controllers.RequestUpload;
import org.ssum.file.exceptions.FileTypeException;

@Service
@RequiredArgsConstructor
public class BeforeFileUploadProcess {

    private final FileDeleteService deleteService;

    /**
     * 파일 이미지 업로드 전 처리
     *
     * @param form
     */


    public void process(RequestUpload form) {
        MultipartFile[] files = form.getFiles();


        //업로드된 파일에서 이미지만 포함되어 있는지 체크
        if (form.isImageOnly()) {
            for (MultipartFile file : form.getFiles()) {
                String contentType = file.getContentType();
                //이미지이면 image/png , image/gif ...
                // 이미지가 아닌 파일이 포함된 경우
                if (!contentType.contains("images/")) {
                    throw new FileTypeException(HttpStatus.BAD_REQUEST);
                    //예외가 던져지면 JSON타입으로 반환

                }
            }
        }

        /**
         * 단일 파일 업로드
         *  - 기존 파일을 gid + location 값을 가지고 삭제
         */

        if (form.isSingle()) {
            deleteService.delete(form.getGid(), form.getLocation(), FileStatus.ALL);
            // 이미지를 여러개 올려도 하나만 남아야쥬 이미지
            form.setFiles(new MultipartFile[]{files[0]});
        }
    }
}
