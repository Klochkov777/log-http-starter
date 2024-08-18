package com.klochkov.starter_log_http.log;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class LogHttpFilter extends HttpFilter {

    private final LogProperties logProperties;
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        log.info("Request with method {}, URI: {}, Parameters: {}", request.getMethod(), request.getRequestURI(), request.getQueryString());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;

        log.info("Response with status={}, duration={}ms", response.getStatus(), duration);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LogHttpFilter initialized with logLevel: {}", logProperties.getLogLevel());
    }

    @Override
    public void destroy() {
        log.info("LogHttpFilter destroyed");
    }
}
