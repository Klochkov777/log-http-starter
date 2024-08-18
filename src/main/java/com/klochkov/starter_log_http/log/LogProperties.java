package com.klochkov.starter_log_http.log;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "log.http")
public class LogProperties {
    boolean enabled = true;
    private String logLevel = "INFO";
}
