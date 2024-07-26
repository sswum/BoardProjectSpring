package org.ssum.global.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file.upload")
@Data
public class FileProperties {
    //설정을 범주별로 따로 분리 해놔야 편리하니까 구분할려는 기능이 있다.

    private String path; // 위에 prefix를 씀으로 file.upload.path로 인식
    private String url; // file.upload.url


}
