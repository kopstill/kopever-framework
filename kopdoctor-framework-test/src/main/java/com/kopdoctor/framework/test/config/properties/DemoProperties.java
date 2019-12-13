package com.kopdoctor.framework.test.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Validated
@ConfigurationProperties(prefix = "demo", ignoreInvalidFields = true)
public class DemoProperties {

    @NotBlank
    private String name;

    private String content;

    @NotNull
    private Integer type;

    @NotNull
    private Integer status;

    private String remark;

    @NotEmpty
    private List<String> list;

    private String camelCaseField;

}
