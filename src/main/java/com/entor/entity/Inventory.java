package com.entor.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@TableName("lms_inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 货物名称
     */
    private String name;

    /**
     * 货物数量
     */
    private Integer num;

    /**
     * 入库时间
     */
    private Date putDate;

    /**
     * 出库时间
     */
    private Date outDate;


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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
        "id=" + id +
        ", name=" + name +
        ", num=" + num +
        ", putDate=" + putDate +
        ", outDate=" + outDate +
        "}";
    }
}
