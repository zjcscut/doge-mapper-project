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
 * @since 2017/8/20 21:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCase {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testSelect()throws Exception{
		//预先已经插入了一条记录,见data/data.sql
		Condition condition = Condition.create(Order.class);
		condition.eq("orderId","orderId-001");
		Order one = orderMapper.selectOneByCondition(condition);
		System.out.println(one);
	}

	@Test
	public void testInsert()throws Exception{
		Order order = new Order();
		order.setOrderId("10086");
		orderMapper.insert(order);
		System.out.println(order);
	}
}
