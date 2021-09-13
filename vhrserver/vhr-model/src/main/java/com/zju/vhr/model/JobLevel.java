package com.zju.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName JobLevel
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 11:54
 * @Version
 */
public class JobLevel implements Serializable{

    private Integer id;
    private String name;
    private String titleLevel;

    public JobLevel(String name) {
        this.name = name;
    }

    public JobLevel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevel jobLevel = (JobLevel) o;
        return Objects.equals(name, jobLevel.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createDate;
    private Boolean enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
