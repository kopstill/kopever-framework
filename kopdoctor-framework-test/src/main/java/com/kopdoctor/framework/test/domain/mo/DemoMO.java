package com.kopdoctor.framework.test.domain.mo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("demo")
@Getter
@Setter
public class DemoMO {

    private Long id;

    private String name;

    private String content;

    private Date date;

    public void setDate(Date date) {
        this.date = date == null ? null : (Date) date.clone();
    }

    public Date getDate() {
        return date == null ? null : (Date) date.clone();
    }

}
