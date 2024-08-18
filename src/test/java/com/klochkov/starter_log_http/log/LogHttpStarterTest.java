package com.klochkov.starter_log_http.log;

import jakarta.servlet.FilterChain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {LogHttpAutoConfig.class})
public class LogHttpStarterTest {
    @Autowired
    private LogHttpFilter logHttpFilter;

    @Test
    void testHttpLoggingFilter() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain chain = (req, res) -> {};

        request.setMethod("GET");
        request.setRequestURI("/test");

        logHttpFilter.doFilter(request, response, chain);

        assertEquals(200, response.getStatus());
    }
}
