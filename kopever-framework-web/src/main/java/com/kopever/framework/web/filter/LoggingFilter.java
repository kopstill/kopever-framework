package com.kopever.framework.web.filter;

import com.kopever.framework.web.request.CachedHttpServletRequest;
import com.kopever.framework.web.util.RequestUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CachedHttpServletRequest cachedRequest = new CachedHttpServletRequest((HttpServletRequest) servletRequest);

        String http = "Request begin. IP: " + cachedRequest.getRemoteAddr() +
                StringUtils.CR + StringUtils.LF +
                RequestUtil.dumpHttpStandardContent(cachedRequest);
        logger.info(http);

        Instant begin = Instant.now();
        filterChain.doFilter(cachedRequest, servletResponse);
        Instant end = Instant.now();
        logger.info("Request end. Takes " + Duration.between(begin, end).toMillis() + "ms");
    }

}
