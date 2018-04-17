package com.ntt.model;

public class EngineDto {
    private String soNo;
    private int marginLeft;
    private int g0width;
    private int g1width;
    private int g2width;
    private int g3width;
    private Option option;

    public String getSoNo() {
        return soNo;
    }

    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getG0width() {
        return g0width;
    }

    public void setG0width(int g0width) {
        this.g0width = g0width;
    }

    public int getG1width() {
        return g1width;
    }

    public void setG1width(int g1width) {
        this.g1width = g1width;
    }

    public int getG2width() {
        return g2width;
    }

    public void setG2width(int g2width) {
        this.g2width = g2width;
    }

    public int getG3width() {
        return g3width;
    }

    public void setG3width(int g3width) {
        this.g3width = g3width;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
