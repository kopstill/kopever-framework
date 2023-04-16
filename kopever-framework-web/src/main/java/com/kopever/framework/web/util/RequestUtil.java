package com.kopever.framework.web.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestUtil {

    public static String dumpHttpStandardContent(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(request.getMethod()).append(StringUtils.SPACE).
                append(request.getRequestURI()).append(StringUtils.defaultIfBlank("?" + request.getQueryString(), StringUtils.EMPTY)).append(StringUtils.SPACE).
                append(request.getProtocol()).append(StringUtils.CR + StringUtils.LF);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            builder.append(headerName).append(":").append(StringUtils.SPACE).append(headerValue).append(StringUtils.CR + StringUtils.LF);
        }

        String contentType = request.getContentType();
        if (StringUtils.isBlank(contentType)) return builder.toString();

        builder.append(StringUtils.CR + StringUtils.LF);

        MediaType mediaType = MediaType.parseMediaType(contentType);
        if (MediaType.APPLICATION_FORM_URLENCODED.equalsTypeAndSubtype(mediaType) || MediaType.MULTIPART_FORM_DATA.equalsTypeAndSubtype(mediaType)) {
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                String parameterValue = request.getParameter(parameterName);
                builder.append(parameterName).append("=").append(parameterValue);
                builder.append(parameterNames.hasMoreElements() ? "&" : StringUtils.EMPTY);
            }
        } else {
            try {
                String body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
                if (StringUtils.isNotBlank(body)) {
                    builder.append(body);
                }
            } catch (IOException e) {
                logger.error("Dump request stream exception", e);
            }
        }

        return builder.toString();
    }

}
