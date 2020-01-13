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
@TableName("lms_cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "cargo_id", type = IdType.AUTO)
    private Integer cargoId;

    /**
     * 货物名称
     */
    private String cargoName;

    /**
     * 货物数量
     */
    private Integer cargoNum;

    /**
     * 货物重量
     */
    private Double cargoWeiht;

    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public Integer getCargoNum() {
        return cargoNum;
    }

    public void setCargoNum(Integer cargoNum) {
        this.cargoNum = cargoNum;
    }

    public Double getCargoWeiht() {
        return cargoWeiht;
    }

    public void setCargoWeiht(Double cargoWeiht) {
        this.cargoWeiht = cargoWeiht;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Cargo{" +
        "cargoId=" + cargoId +
        ", cargoName=" + cargoName +
        ", cargoNum=" + cargoNum +
        ", cargoWeiht=" + cargoWeiht +
        ", orderId=" + orderId +
        ", createTime=" + createTime +
        "}";
    }
}
