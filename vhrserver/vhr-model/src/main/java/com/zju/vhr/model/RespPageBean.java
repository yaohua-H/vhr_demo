package com.zju.vhr.model;

import java.util.List;

/**
 * @ClassName RespPageBean
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 19:35
 * @Version
 */
public class RespPageBean {

    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
