package org.ssum.ApiTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@ActiveProfiles("test")
@SpringBootTest
public class Apitest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void test1() {
        String url = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?MobileOS=AND&MobileApp=test&mapX=126.943232&mapY=37.5586816&radius=1000&serviceKey=CHrWrFoNSLs09ec0iaNNKpj3VuYnP%2BJA5WAtHyPqdDVCdF%2Fn1NB46%2Bfd2NDjlTiNm%2Fw48BE9guQbOo12k2a6wA%3D%3D&_type=json";

        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(url), String.class);

        System.out.println(response);
    }
}
