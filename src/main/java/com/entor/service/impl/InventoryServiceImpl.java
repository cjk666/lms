package com.entor.service.impl;

import com.entor.entity.Inventory;
import com.entor.mapper.InventoryMapper;
import com.entor.service.IInventoryService;
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
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

}
