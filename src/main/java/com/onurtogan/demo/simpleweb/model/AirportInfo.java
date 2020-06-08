package com.onurtogan.demo.simpleweb.model;

public class AirportInfo {
    private String name;
    private String code1;
    private String code2;

    public AirportInfo() {
    }

    public AirportInfo(String name, String code1, String code2) {
        this.name = name;
        this.code1 = code1;
        this.code2 = code2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
