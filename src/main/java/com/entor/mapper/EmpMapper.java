package com.entor.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entor.entity.Emp;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
public interface EmpMapper extends BaseMapper<Emp> {
	
	@Select("select  * from lms_emp where username = #{username} and password = #{password}")
	public Emp login(@Param("username")String username, @Param("password")String password);
	
}
