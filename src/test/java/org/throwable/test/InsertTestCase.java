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
 * @since 2017/9/17 21:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class InsertTestCase {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testInsert()throws Exception{
		Order order = new Order();
		order.setOrderId("order-011");
		order.setAmount(10000);
		orderMapper.insert(order);

		Condition condition = Condition.create(Order.class);
		condition.eq("orderId", order.getOrderId());
		Order result = orderMapper.selectOneByCondition(condition);
		System.out.println(result);
	}

	@Test
	public void testInsertIgnore()throws Exception{
		Order order = new Order();
		order.setOrderId("order-012");
		order.setAmount(10000);
		orderMapper.insertIgnore(order);
		Condition condition = Condition.create(Order.class);
		condition.eq("orderId", order.getOrderId());
		Order result = orderMapper.selectOneByCondition(condition);
		System.out.println(result);
	}

	@Test
	public void testInsertSkipNull()throws Exception{
		Order order = new Order();
		order.setOrderId("order-013");
		orderMapper.insertSkipNull(order);
		Condition condition = Condition.create(Order.class);
		condition.eq("orderId", order.getOrderId());
		Order result = orderMapper.selectOneByCondition(condition);
		System.out.println(result);
	}

	@Test
	public void testInsertIgnoreSkipNull()throws Exception{
		Order order = new Order();
		order.setOrderId("order-014");
		orderMapper.insertIgnoreSkipNull(order);
		Condition condition = Condition.create(Order.class);
		condition.eq("orderId", order.getOrderId());
		Order result = orderMapper.selectOneByCondition(condition);
		System.out.println(result);
	}
}
