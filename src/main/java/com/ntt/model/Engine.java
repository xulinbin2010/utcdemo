package com.ntt.model;

import java.util.Date;

public class Engine {
    private Integer id;

    private String soNo;

    private String engineModle;

    private String customer;

    private String optionId;

    private String startDate;

    private Option option;

    private Integer g0days;

    private Integer g1days;

    private Integer g2days;

    private Integer g3days;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoNo() {
        return soNo;
    }

    public void setSoNo(String soNo) {
        this.soNo = soNo == null ? null : soNo.trim();
    }

    public String getEngineModle() {
        return engineModle;
    }

    public void setEngineModle(String engineModle) {
        this.engineModle = engineModle == null ? null : engineModle.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId == null ? null : optionId.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Integer getG0days() {
        return g0days;
    }

    public void setG0days(Integer g0days) {
        this.g0days = g0days;
    }

    public Integer getG1days() {
        return g1days;
    }

    public void setG1days(Integer g1days) {
        this.g1days = g1days;
    }

    public Integer getG2days() {
        return g2days;
    }

    public void setG2days(Integer g2days) {
        this.g2days = g2days;
    }

    public Integer getG3days() {
        return g3days;
    }

    public void setG3days(Integer g3days) {
        this.g3days = g3days;
    }
}