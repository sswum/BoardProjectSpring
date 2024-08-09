package org.ssum.file.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.ssum.file.constants.FileStatus;
import org.ssum.file.entities.FileInfo;
import org.ssum.file.repositories.FileInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUploadDoneService {
    private final FileInfoRepository repository;
    private final FileInfoService infoService;

    public void process(String gid, String location) {

        List<FileInfo> items = infoService.getList(gid, location, FileStatus.ALL);
        items.forEach(i -> i.setDone(true));

        repository.saveAllAndFlush(items);
    }

    public void process(String gid) {
        process(gid, null);
    }
}
