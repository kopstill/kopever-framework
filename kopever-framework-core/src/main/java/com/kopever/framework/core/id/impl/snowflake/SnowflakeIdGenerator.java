package com.kopever.framework.core.id.impl.snowflake;

import com.kopever.framework.core.id.NumberIdGenerator;

public class SnowflakeIdGenerator implements NumberIdGenerator {

    private static final long DEFAULTWORKERID = 0;

    private static final long DEFAULTDATACENTERID = 0;

    private static final SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(DEFAULTWORKERID, DEFAULTDATACENTERID);

    @Override
    public long getLong() {
        return snowflakeIdWorker.nextId();
    }

}
