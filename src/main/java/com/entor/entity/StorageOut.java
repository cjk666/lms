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
@TableName("lms_storage_out")
public class StorageOut implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库时间
     */
    private Date outDate;

    /**
     * 领取人
     */
    private String takeName;

    /**
     * 仓库编号
     */
    private Integer storageId;

    /**
     * 货物编号
     */
    private Integer cargoId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Override
    public String toString() {
        return "StorageOut{" +
        "id=" + id +
        ", outDate=" + outDate +
        ", takeName=" + takeName +
        ", storageId=" + storageId +
        ", cargoId=" + cargoId +
        "}";
    }
}
