package com.ntt.model;

public class Option {
    private Integer id;

    private String opname;

    private Integer gZero;

    private Integer gOne;

    private Integer gTwo;

    private Integer gThree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpname() {
        return opname;
    }

    public void setOpname(String opname) {
        this.opname = opname == null ? null : opname.trim();
    }

    public Integer getgZero() {
        return gZero;
    }

    public void setgZero(Integer gZero) {
        this.gZero = gZero;
    }

    public Integer getgOne() {
        return gOne;
    }

    public void setgOne(Integer gOne) {
        this.gOne = gOne;
    }

    public Integer getgTwo() {
        return gTwo;
    }

    public void setgTwo(Integer gTwo) {
        this.gTwo = gTwo;
    }

    public Integer getgThree() {
        return gThree;
    }

    public void setgThree(Integer gThree) {
        this.gThree = gThree;
    }
}