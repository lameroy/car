package com.car.mapper;

import com.car.common.PageQuery;

import java.util.List;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/9/2 11:10
 * @Modified By：
 */
public interface BaseMapper<T> {

    T read(Integer num);

    int update(T t);

    int save(T t);

    List<T> list(PageQuery query);
}
