package com.kopever.framework.web.filter;

import com.kopever.framework.web.request.CachedHttpServletRequest;
import com.kopever.framework.web.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CachedHttpServletRequest cachedRequest = new CachedHttpServletRequest((HttpServletRequest) servletRequest);

        logger.info("Request begin. IP: " + cachedRequest.getRemoteAddr() + StringUtils.LF + RequestUtil.dumpHttpStandardContent(cachedRequest));

        Instant begin = Instant.now();

        filterChain.doFilter(cachedRequest, servletResponse);

        Instant end = Instant.now();

        logger.info("Request end. Takes " + Duration.between(begin, end).toMillis() + "ms");
    }

}