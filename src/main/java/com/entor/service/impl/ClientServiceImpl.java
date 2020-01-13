package com.entor.service.impl;

import com.entor.entity.Client;
import com.entor.mapper.ClientMapper;
import com.entor.service.IClientService;
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
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

}
