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
@TableName("lms_emp")
public class Emp implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工性别
     */
    private Integer sex;

    /**
     * 员工年龄
     */
    private Integer age;

    /**
     * 员工联系电话
     */
    private String phone;

    /**
     * 员工联系地址
     */
    private String address;

    /**
     * 员工学历
     */
    private String edu;

    /**
     * 员工生日
     */
    private Date birthday;

    /**
     * 员工所在部门
     */
    private String dept;

    /**
     * 员工职位
     */
    private String job;
    
    /**
     * 角色编号 
     */
    private int roleId;
    
    public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", age=" + age +
        ", phone=" + phone +
        ", address=" + address +
        ", edu=" + edu +
        ", birthday=" + birthday +
        ", dept=" + dept +
        ", job=" + job +
        "}";
    }
}
