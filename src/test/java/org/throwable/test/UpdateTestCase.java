package org.throwable.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;
import org.throwable.dao.OrderMapper;
import org.throwable.entity.Order;
import org.throwable.mapper.core.support.plugins.condition.Condition;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/9/17 21:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UpdateTestCase {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testUpdateByPrimaryKeySkipNull() throws Exception{
		Condition condition = Condition.create(Order.class);
		condition.eq("id", 1L);
		Order order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
		order.setAmount(null);
		orderMapper.updateByPrimaryKey(order);
		order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
	}

	@Test
	public void testUpdateByPrimaryKeyNoneSkipNull() throws Exception{
		Condition condition = Condition.create(Order.class);
		condition.eq("id", 1L);
		Order order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
		order.setAmount(null);
		orderMapper.updateByPrimaryKey(order,true);
		order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
	}

	@Test
	public void testUpdateByCondition() throws Exception{
		Condition condition = Condition.create(Order.class);
		condition.eq("id", 1L);
		Order order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
		condition.setVar("amount", 10086);
		orderMapper.updateByCondition(condition);
		order = orderMapper.selectOneByCondition(condition);
		System.out.println("SELECT --> " + order);
	}
}
