package com.bob.ssm.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */
public class WebSubject {

    String id;
    String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String classID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

}
