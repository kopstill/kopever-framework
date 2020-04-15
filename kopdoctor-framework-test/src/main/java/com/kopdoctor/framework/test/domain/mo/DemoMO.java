package com.kopdoctor.framework.test.domain.mo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("demo")
@Getter
@Setter
public class DemoMO {

    private String id;

    private String demoName;

    private String demoContent;

    private Integer demoType;

    private Integer demoStatus;

    private String remark;

    private Date createTime;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null ? null : (Date) createTime.clone();
    }

    public Date getCreateTime() {
        return createTime == null ? null : (Date) createTime.clone();
    }

}
