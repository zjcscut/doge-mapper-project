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

import java.util.ArrayList;
import java.util.List;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/8/20 21:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BatchTestCase {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testBatchUpdate() throws Exception {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order() {{
			this.setId(1L);
			this.setOrderId("orderId-00001-modify");
		}});
		orders.add(new Order() {{
			this.setId(2L);
			this.setOrderId("orderId-00002-modify");
		}});
		int update = orderMapper.batchUpdateByPrimaryKeyForeach(orders, true);
		System.out.println("update --> " + update);
		Condition condition = Condition.create(Order.class);
		condition.in("id", "(1,2)");
		List<Order> selects = orderMapper.selectByCondition(condition);
		System.out.println(selects);

		orders.get(0).setOrderId("orderId-00001-modify2");
		orders.get(1).setOrderId("orderId-00002-modify2");
		update = orderMapper.batchUpdateByPrimaryKeyWhenCase(orders, true);
		System.out.println("update2 --> " + update);
		selects = orderMapper.selectByCondition(condition);
		System.out.println(selects);
	}

	@Test
	public void testBatchInsert() throws Exception {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order() {{
			this.setOrderId("orderId-00001");
			this.setAmount(10087);
		}});

		orders.add(new Order() {{
			this.setOrderId("orderId-00002");
			this.setAmount(10088);
		}});
		orderMapper.batchInsert(orders);

		System.out.println("before select --> " + orders);

		Condition condition = Condition.create(Order.class);
		condition.gt("id", 0L);
		List<Order> orderList = orderMapper.selectByCondition(condition);
		System.out.println(orderList);
	}

}
