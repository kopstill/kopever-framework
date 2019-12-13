package com.kopdoctor.framework.test.domain.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DemoDO {

    private Long id;

    private String demoName;

    private String demoContent;

    private Short demoType;

    private Byte demoStatus;

    private String remark;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

}
