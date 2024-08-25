package org.ssum.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.ssum.file.contants.FileStatus;
import org.ssum.file.entities.FileInfo;
import org.ssum.file.repositories.FileInfoRepository;
import org.ssum.global.entities.Member;
import org.ssum.global.exceptions.UnAuthorizedException;
import org.ssum.member.MemberUtil;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileDeleteService {
    private final FileInfoService infoService;
    private final FileInfoRepository infoRepository;
    private final MemberUtil memberUtil; // 로그인 했는지 안했는지 여부에 따라서

    //삭제할 때 중요한 것은 파일의 정보 삭제

    //낱개 삭제
    public FileInfo delete(long seq) {
        FileInfo data = infoService.get(seq); //삭제 전에 파일을 먼저 가져오기
        String filePath = data.getFilePath();
        String createBy = data.getCreateBy(); //업로드한 회원 이메일로 확인

        Member member = memberUtil.getMember(); //로그인한 회원 정보 가져오기
        if (!memberUtil.isAdmin() && StringUtils.hasText(createBy) && memberUtil.isLogin() && !member.getEmail().equals(createBy)) {
            throw new UnAuthorizedException(); //권한 없음 예외처리
        }
        //파일 삭제
        File file = new File(filePath);
        if (file.exists()) { //파일이 존재하는지 먼저 체크하고 삭제해야 오류가 안 난다.
            file.delete();

        }
        //파일 정보 삭제
        infoRepository.delete(data);
        infoRepository.flush();

        return data; // 삭제가 됐는지 다시 데이타 확인
    }

    public List<FileInfo> delete(String gid, String location, FileStatus status) {
        List<FileInfo> items = infoService.getList(gid, location, status);
        items.forEach(i -> delete(i.getSeq()));

        return items;
    }

    public List<FileInfo> delete(String gid, String location) {
        return delete(gid, location, FileStatus.ALL);
    }

    public List<FileInfo> delete(String gid) {
        return delete(gid, null);
    }

}
