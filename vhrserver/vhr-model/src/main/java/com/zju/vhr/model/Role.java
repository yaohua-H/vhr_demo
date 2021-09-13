package com.zju.vhr.model;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description
 * @Author Administrator
 * @Date 2021/4/24 18:27
 * @Version
 */
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String nameZh;

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
        this.name = name == null ? null : name.trim();
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
