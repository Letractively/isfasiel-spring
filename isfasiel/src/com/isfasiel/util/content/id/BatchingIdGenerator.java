package com.isfasiel.util.content.id;

public class BatchingIdGenerator implements IdGenerator {

	private IdGenerator generator;
	private int batchSize = 100;
	private long current = 0;
	private long max;
	
	public BatchingIdGenerator(IdGenerator generator) {
		this.generator = generator;
	}
	
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	
	@Override
	public long getNextId(int granularity) {
		current += granularity;
		if(current> max) {
			current = generator.getNextId(batchSize);
			max = current + batchSize;
		}
		return current;
	}

}
