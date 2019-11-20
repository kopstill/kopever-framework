package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request<T> {

    private RequestHead head;

    private T body;

}
