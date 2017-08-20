package org.throwable.test;

import org.throwable.mapper.core.support.plugins.generator.identity.LongPrimaryKeyGenerator;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/8/20 21:12
 */
public class CustomerLongGenerator implements LongPrimaryKeyGenerator{

	@Override
	public Long generatePrimaryKey() {
		return System.currentTimeMillis();
	}
}
