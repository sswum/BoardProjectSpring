package org.ssum.global.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file.upload")
@Data
public class FileProperties {

    private String path;
    private String url;


}
