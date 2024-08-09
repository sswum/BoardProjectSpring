package org.ssum.mypage.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssum.member.services.MemberSaveService;
import org.ssum.mypage.controllers.RequestProfile;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MemberSaveService saveService;


    public void update(RequestProfile form) {

    }
}