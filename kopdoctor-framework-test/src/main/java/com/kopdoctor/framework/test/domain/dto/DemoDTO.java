package com.kopdoctor.framework.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DemoDTO {

    private Long id;

    private String demoName;

    private String demoContent;

    private Short demoType;

    private Byte demoStatus;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
