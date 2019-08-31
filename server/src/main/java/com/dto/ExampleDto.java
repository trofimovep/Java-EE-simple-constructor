package com.dto;

import javax.xml.bind.annotation.XmlElement;

public class ExampleDto {

    @XmlElement
    private long id;
    @XmlElement
    private String name;

    public ExampleDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
