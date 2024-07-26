package org.ssum.global.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true); //오류가 뜨면 코드가 뜨게끔 설정하겠다.
        ms.setBasenames("messages.commons","messages.validations","messages.errors"); //경로 설정

        return ms;
    }
}
