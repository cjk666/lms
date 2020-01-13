package com.entor.service.impl;

import com.entor.entity.Line;
import com.entor.mapper.LineMapper;
import com.entor.service.ILineService;
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
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements ILineService {

}
