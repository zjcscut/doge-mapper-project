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
import org.throwable.mapper.core.support.plugins.pagination.PageModel;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/9/17 20:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SelectTestCase {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testSelectByConditionLimitOffset() throws Exception {
		Condition condition = Condition.create(Order.class);
		condition.gt("id", 0L);
		PageModel<Order> orderPageModel = orderMapper.selectByConditionLimitOffset(condition, 1, 2);
		System.out.println(orderPageModel.getResult());
		orderPageModel = orderMapper.selectByConditionLimitOffset(condition, 2, 2);
		System.out.println(orderPageModel.getResult());
	}

	@Test
	public void testSelectByConditionPage()throws Exception{
		Condition condition = Condition.create(Order.class);
		condition.gt("id", 0L);
		PageModel<Order> orderPageModel = orderMapper.selectByConditionPage(condition,1,2);
		System.out.println(orderPageModel.getResult());
		orderPageModel = orderMapper.selectByConditionPage(condition, 2, 2);
		System.out.println(orderPageModel.getResult());
	}

}
