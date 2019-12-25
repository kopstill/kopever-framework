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
        CachedHttpServletRequest request = new CachedHttpServletRequest((HttpServletRequest) servletRequest);

        logger.info("Request begin" + StringUtils.LF + RequestUtil.dumpHttpStandardContent(request));

        Instant begin = Instant.now();

        filterChain.doFilter(request, servletResponse);

        Instant end = Instant.now();

        logger.info("Request end. Takes " + Duration.between(begin, end).toMillis() + "ms");
    }

}
