package org.throwable.entity;

import org.throwable.mapper.core.common.annotation.Column;
import org.throwable.mapper.core.common.annotation.Id;
import org.throwable.mapper.core.common.annotation.Table;
import org.throwable.test.CustomerLongGenerator;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/8/20 21:13
 */
@Table("t_order")
public class Order {

	@Id(value = "id", keyGenerator = CustomerLongGenerator.class)
	private Long id;
	@Column(value = "order_id")
	private String orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderId='" + orderId + '\'' +
				'}';
	}
}
