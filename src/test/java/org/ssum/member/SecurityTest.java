package org.ssum.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
public class SecurityTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        mockMvc.perform(post("/member/join")
                .param("email","user02@test.org"))
                .andDo(print());
    }
    @Test
    @WithMockUser
    void test2() throws Exception {
        mockMvc.perform(get("/mypage"))
                .andDo(print());
    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    void test3() throws Exception {
        mockMvc.perform(get("/admin"))
                .andDo(print());
    }

}
