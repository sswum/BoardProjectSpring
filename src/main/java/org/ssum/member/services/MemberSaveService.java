package org.ssum.member.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.ssum.global.entities.Member;
import org.ssum.member.constants.Authority;
import org.ssum.member.controllers.RequestJoin;
import org.ssum.member.entities.Authorities;
import org.ssum.member.repositories.AuthoritiesRepository;
import org.ssum.member.repositories.MemberRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 처리
     *
     * @param form
     */
    public void save(RequestJoin form) {
        Member member = new ModelMapper().map(form, Member.class);
        String hash = passwordEncoder.encode(form.getPassword()); // BCrypt 해시화
        member.setPassword(hash);

        save(member, List.of(Authority.USER));
    }

    public void save(Member member, List<Authority> authorities) {

        // 휴대전화번호 숫자만 기록
        String mobile = member.getMobile();
        if (StringUtils.hasText(mobile)) {
            mobile = mobile.replaceAll("\\D", ""); //-는 빼고 숫자만 남기도록
            member.setMobile(mobile); //번호 검색할 때 형식이 동일하면 검색하기 쉽기 때문에
        }

        memberRepository.saveAndFlush(member); // 회원을 다 조회하고 저장한당

        //권한 추가 , 수정 S
        if (authorities != null) {
            List<Authorities> items = authoritiesRepository.findByMember(member);
            authoritiesRepository.deleteAll(items);
            authoritiesRepository.flush(); //가져오고 나서 싹 지우고 영속성 저장

            items = authorities.stream().map(a -> Authorities.builder().member(member).authority(a).build()).toList();

            authoritiesRepository.saveAllAndFlush(items);
        }
        //권한 추가 , 수정 E
        //모두 추가하거나 수정할때는 영속성 안에 있어야만 가능하다.
    }
}