package com.entor.mapper;

import com.entor.entity.ClientVip;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
public interface ClientVipMapper extends BaseMapper<ClientVip> {
	
	@Select("select * from lms_client_vip where username = #{username} and password = #{password}")
	public ClientVip login(@Param("username")String username, @Param("password")String password);
	
}
