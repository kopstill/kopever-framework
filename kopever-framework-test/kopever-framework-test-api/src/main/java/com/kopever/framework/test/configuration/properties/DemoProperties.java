package com.kopever.framework.test.configuration.properties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

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
