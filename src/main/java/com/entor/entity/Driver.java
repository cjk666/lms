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
@TableName("lms_driver")
public class Driver implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "driver_id", type = IdType.AUTO)
    private Integer driverId;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机性别（1男 2女）
     */
    private Integer driverSex;

    /**
     * 司机联系电话
     */
    private String driverPhone;

    /**
     * 司机家庭住址
     */
    private String driverAddress;

    /**
     * 司机生日
     */
    private Date driverBirthday;

    /**
     * 司机驾驶证级别（A1 A2...）
     */
    private String driverType;

    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverSex() {
        return driverSex;
    }

    public void setDriverSex(Integer driverSex) {
        this.driverSex = driverSex;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public Date getDriverBirthday() {
        return driverBirthday;
    }

    public void setDriverBirthday(Date driverBirthday) {
        this.driverBirthday = driverBirthday;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Driver{" +
        "driverId=" + driverId +
        ", driverName=" + driverName +
        ", driverSex=" + driverSex +
        ", driverPhone=" + driverPhone +
        ", driverAddress=" + driverAddress +
        ", driverBirthday=" + driverBirthday +
        ", driverType=" + driverType +
        ", createTime=" + createTime +
        "}";
    }
}
