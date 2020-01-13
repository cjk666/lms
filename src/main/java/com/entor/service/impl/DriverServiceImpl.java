package com.entor.service.impl;

import com.entor.entity.Driver;
import com.entor.mapper.DriverMapper;
import com.entor.service.IDriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjk
 * @since 2020-01-06
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements IDriverService {

}
