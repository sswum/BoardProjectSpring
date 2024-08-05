package org.ssum.file.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssum.global.entities.BaseMemberEntity;

import java.util.UUID;


@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Data
public class FileInfo extends BaseMemberEntity {
    @Id
    @GeneratedValue
    private Long seq; // 파일 등록 번호, 서버에 업로드하는 파일명 - seq.확장자

    @Column(length=45, nullable = false)
    private String gid = UUID.randomUUID().toString(); // 그룹 ID

    @Column(length=45)
    private String location; // 그룹 안에 세부 위치

    @Column(length=80 , nullable = false)
    private String fileName;

    @Column(length = 80)
    private String contentType;

    private boolean done; // 그룹 작업 완료 여부

    @Column(length=30)
    private String extension; // 파일 확장자

    @Transient //DB에 올라가진 않고 내부에서 쓸 목적인 트랜지엔트
    private String filePath; // 서버에 실제 올라간 경로

    @Transient
    private String fileUrl; // 브라우저 주소창에 입력해서 접근할 수 있는 경로

    /*




    @Transient
    private List<String> thumbsPath; // 썸네일 이미지 경로

    @Transient
    private List<String> thumbsUrl; // 브라우저 주소창에 입력해서 접근할 수 있는 경로
     */
}
