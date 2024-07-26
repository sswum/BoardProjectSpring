package org.ssum.global.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@EnableConfigurationProperties(FileProperties.class)
@Configuration
public class FileConfig implements WebMvcConfigurer {
    //정적 경로와 실제 파일 패스와 웹에서 접근할 수 있도록

    private final FileProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(properties.getUrl() + "**")
                .addResourceLocations("file:///" + properties.getPath());
    }
}
