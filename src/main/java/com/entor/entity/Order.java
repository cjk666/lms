package com.entor.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("lms_order")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单号
     */
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private String orderId;

    /**
     * 发货地址
     */
    private String sendSite;

    /**
     * 收货地址
     */
    private String receSite;

    /**
     * 发货人姓名
     */
    private String sendName;


    /**
     * 发货人联系电话
     */
    private String sendPhone;

    /**
     * 收货人姓名
     */
    private String receName;


    /**
     * 收货人联系电话
     */
    private String recePhone;


    /**
     * 订单状态
     */
    private Integer orderStatue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;



    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSendSite() {
        return sendSite;
    }

    public void setSendSite(String sendSite) {
        this.sendSite = sendSite;
    }

    public String getReceSite() {
        return receSite;
    }

    public void setReceSite(String receSite) {
        this.receSite = receSite;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }


    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getRecePhone() {
        return recePhone;
    }

    public void setRecePhone(String recePhone) {
        this.recePhone = recePhone;
    }

    public Integer getOrderStatue() {
		return orderStatue;
	}

	public void setOrderStatue(Integer orderStatue) {
		this.orderStatue = orderStatue;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", sendSite=" + sendSite + ", receSite=" + receSite + ", sendName="
				+ sendName + ", sendPhone=" + sendPhone + ", receName=" + receName
				+ ", recePhone=" + recePhone + ", orderStatue=" + orderStatue + ", remark="
				+ remark + ", createTime=" + createTime + "]";
	}
    
}

