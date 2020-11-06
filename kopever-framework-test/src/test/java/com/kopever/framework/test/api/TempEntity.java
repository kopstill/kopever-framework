package com.kopever.framework.test.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TempEntity {

    private Long id;

    private String name;

    private Date time;

    public Date getTime() {
        return time == null ? null : (Date) time.clone();
    }

    public void setTime(Date time) {
        this.time = time == null ? null : (Date) time.clone();
    }

}
