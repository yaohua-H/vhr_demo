package com.zju.vhr.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Politicsstatus
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 18:34
 * @Version
 */
public class Politicsstatus implements Serializable {

    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Politicsstatus that = (Politicsstatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public Politicsstatus() {
    }

    public Politicsstatus(String name) {
        this.name = name;
    }

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
}
