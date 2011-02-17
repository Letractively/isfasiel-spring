package com.isfasiel.util.content.id;

import java.util.concurrent.atomic.AtomicLong;

public class SimpleIdGenerator implements IdGenerator {

	private AtomicLong id = new AtomicLong(0L);
	
	@Override
	public long getNextId(int granularity) {
		return id.getAndAdd(granularity);
	}

}
