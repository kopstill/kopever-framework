package com.kopever.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestHead {

    private String requestId;

    private Long timestamp;

    private String version;

    private String encoding;

}
