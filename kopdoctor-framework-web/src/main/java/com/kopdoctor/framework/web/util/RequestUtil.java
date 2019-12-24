package com.kopdoctor.framework.web.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestUtil {

    public static String dumpHttpStandardContent(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(request.getMethod()).append(StringUtils.SPACE).
                append(request.getRequestURI()).append(StringUtils.defaultIfBlank(request.getQueryString(), StringUtils.EMPTY)).append(StringUtils.SPACE).
                append(request.getProtocol()).append(StringUtils.LF);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            builder.append(headerName).append(":").append(StringUtils.SPACE).append(headerValue).append(StringUtils.LF);
        }

        builder.append(StringUtils.LF);

        try {
            InputStreamReader reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
            String body = IOUtils.toString(reader);
            if (StringUtils.isNotBlank(body)) {
                builder.append(body);
            }
        } catch (IOException e) {
            logger.error("Dump request exception", e);
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            builder.append(parameterName).append("=").append(parameterValue);
            builder.append(parameterNames.hasMoreElements() ? "&" : StringUtils.EMPTY);
        }

        return builder.toString();
    }

}
