package org.ssum.global;

import lombok.Data;

@Data
public class CommonSearch { // 공통 검색
    private int page = 1;  // 페이지 시작 번호
    private int limit = 20; // 한 페이지에 출력될 갯수

    private String sopt; // 검색 옵션
    private String skey; // 검색 키워드
}

