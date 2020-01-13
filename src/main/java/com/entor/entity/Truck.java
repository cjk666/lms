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
@TableName("lms_truck")
public class Truck implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "truck_id", type = IdType.AUTO)
    private Integer truckId;

    /**
     * 车型名称
     */
    private String truckName;

    /**
     * 车辆尺寸（M）（长*宽*高）
     */
    private Double truckSize;

    /**
     * 载重
     */
    private Double truckWeiht;

    /**
     * 自重
     */
    private Double truckSelfWeiht;

    /**
     * 车牌号码
     */
    private String truvkPlateNo;

    /**
     * 购入时间
     */
    private Date buyDate;

    /**
     * 主驾驶员
     */
    private Integer driverMainId;

    /**
     * 驾驶员
     */
    private Integer driverId;


    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public Double getTruckSize() {
        return truckSize;
    }

    public void setTruckSize(Double truckSize) {
        this.truckSize = truckSize;
    }

    public Double getTruckWeiht() {
        return truckWeiht;
    }

    public void setTruckWeiht(Double truckWeiht) {
        this.truckWeiht = truckWeiht;
    }

    public Double getTruckSelfWeiht() {
        return truckSelfWeiht;
    }

    public void setTruckSelfWeiht(Double truckSelfWeiht) {
        this.truckSelfWeiht = truckSelfWeiht;
    }

    public String getTruvkPlateNo() {
        return truvkPlateNo;
    }

    public void setTruvkPlateNo(String truvkPlateNo) {
        this.truvkPlateNo = truvkPlateNo;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getDriverMainId() {
        return driverMainId;
    }

    public void setDriverMainId(Integer driverMainId) {
        this.driverMainId = driverMainId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Truck{" +
        "truckId=" + truckId +
        ", truckName=" + truckName +
        ", truckSize=" + truckSize +
        ", truckWeiht=" + truckWeiht +
        ", truckSelfWeiht=" + truckSelfWeiht +
        ", truvkPlateNo=" + truvkPlateNo +
        ", buyDate=" + buyDate +
        ", driverMainId=" + driverMainId +
        ", driverId=" + driverId +
        "}";
    }
}
