package com.kopever.framework.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kopever.framework.core.validation.IntEnum;
import com.kopever.framework.core.validation.ValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DemoDTO {

    @NotNull(groups = {ValidationGroup.Update.class, ValidationGroup.Delete.class, ValidationGroup.Query.class})
    private Long id;

    @NotBlank(groups = ValidationGroup.Create.class)
    private String demoName;

    @NotBlank(groups = ValidationGroup.Create.class)
    private String demoContent;

    @NotNull(groups = ValidationGroup.Create.class)
    @IntEnum(enums = {1, 2, 3})
    private Integer demoType;

    @NotNull(groups = ValidationGroup.Create.class)
    private Integer demoStatus;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Date getCreateTime() {
        return createTime == null ? null : (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null ? null : (Date) createTime.clone();
    }

}
