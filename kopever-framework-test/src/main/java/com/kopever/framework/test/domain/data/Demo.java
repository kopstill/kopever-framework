package com.kopever.framework.test.domain.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Demo {

    private Long id;

    private String demoName;

    private String demoContent;

    private Short demoType;

    private Byte demoStatus;

    private String remark;

    private Boolean isDeleted;

    private Date createTime;

    public Date getCreateTime() {
        return createTime == null ? null : (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null ? null : (Date) createTime.clone();
    }

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime == null ? null : (Date) updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime == null ? null : (Date) updateTime.clone();
    }

}
