package com.kopdoctor.framework.web.filter;

import com.kopdoctor.framework.web.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        logger.info(RequestUtil.dumpHttpStandardContent(request));

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
