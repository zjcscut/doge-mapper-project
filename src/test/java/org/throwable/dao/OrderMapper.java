package org.throwable.dao;

import org.apache.ibatis.annotations.Mapper;
import org.throwable.entity.Order;
import org.throwable.mapper.DogeMapper;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/8/20 21:14
 */
@Mapper
public interface OrderMapper extends DogeMapper<Order> {
}
