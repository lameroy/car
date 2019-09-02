package com.car.service.impl;

import com.car.mapper.BaseMapper;
import com.car.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/9/2 11:19
 * @Modified By：
 */
@Service
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public T read(Integer num) {
        return baseMapper.read(num);
    }
}
