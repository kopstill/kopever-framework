package com.kopever.framework.core.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigKey {

    public static final String FILTER_LOGGING_ENABLED = "kopever.framework.filter.logging.enabled"; // default false

    public static final String FILTER_LOGGING_URL_PATTERNS = "kopever.framework.filter.logging.url-patterns"; // default "/*"

}
