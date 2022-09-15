package com.example.resterrorhandling;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rest-error-handling")
@Data
public class RestErrorHandlingProperties {

    private boolean enabled;

    private String restErrorHandlingFileName;
}
