package com.kopdoctor.framework.web.filter;

import com.kopdoctor.framework.web.request.CachedHttpServletRequest;
import com.kopdoctor.framework.web.util.RequestUtil;
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
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        CachedHttpServletRequest cachedRequest = new CachedHttpServletRequest(httpServletRequest);

        logger.info("Request begin. IP: " + cachedRequest.getRemoteAddr() + StringUtils.LF + RequestUtil.dumpHttpStandardContent(httpServletRequest));

        Instant begin = Instant.now();

        filterChain.doFilter(cachedRequest, servletResponse);

        Instant end = Instant.now();

        logger.info("Request end. Takes " + Duration.between(begin, end).toMillis() + "ms");
    }

}
