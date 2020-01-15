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
@TableName("lms_storage_put")
public class StoragePut implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 入库时间
     */
    private Date putDate;

    /**
     * 入库人姓名
     */
    private String putName;

    /**
     * 仓库编号
     */
    private Integer storageId;

    /**
     * 货物编号
     */
    private Integer cargoId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public String getPutName() {
        return putName;
    }

    public void setPutName(String putName) {
        this.putName = putName;
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
        return "StoragePut{" +
        "id=" + id +
        ", putDate=" + putDate +
        ", putName=" + putName +
        ", storageId=" + storageId +
        ", cargoId=" + cargoId +
        "}";
    }
}
