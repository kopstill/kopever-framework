package com.kopdoctor.framework.core.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigKey {

    public static final String FILTER_LOGGING_ENABLED = "kopdoctor.framework.filter.logging.enabled"; // default false

    public static final String FILTER_LOGGING_URL_PATTERNS = "kopdoctor.framework.filter.logging.url-patterns"; // default "/*"

}
