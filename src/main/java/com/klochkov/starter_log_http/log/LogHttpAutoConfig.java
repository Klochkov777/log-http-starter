package com.klochkov.starter_log_http.log;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogHttpAutoConfig {
    @Bean
    @ConditionalOnProperty(name = "log.http.enabled", havingValue = "true", matchIfMissing = true)
    public LogHttpFilter httpLoggingFilter(LogProperties logProperties) {
        return new LogHttpFilter(logProperties);
    }
}
