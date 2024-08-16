package org.ssum.global.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@Configuration


public class MvcConfig implements WebMvcConfigurer {

    /*
    <input type="hidden" name="_method" value="PATHCH"> ->PATCH 방식으로 요청
    ?_method=DELETE
    @return
    뭐 요렇게 쓰면 방식이 변경될거다.
     */
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter() {

        return new HiddenHttpMethodFilter();
    }
}
