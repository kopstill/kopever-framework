package com.kopdoctor.framework.core.id.impl.snowflake;

import com.kopdoctor.framework.core.id.IdGenerator;

public class SnowflakeIdGenerator implements IdGenerator {

    private static final long DEFAULTWORKERID = 0;

    private static final long DEFAULTDATACENTERID = 0;

    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(DEFAULTWORKERID, DEFAULTDATACENTERID);

    public long getLong() {
        return snowflakeIdWorker.nextId();
    }

}
