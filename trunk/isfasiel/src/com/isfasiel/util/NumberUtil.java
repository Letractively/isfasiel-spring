package com.isfasiel.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberUtil {
	
	@Autowired
	ObjectUtil objectUtil;
	
	public long[] add(long[] list, Object value) {
		return add(list, objectUtil.toLong(value));
	}
	
	public long[] add(long[] list, long value) {
		if(list == null)
			return new long[]{value};
		long[] joined = new long[list.length + 1];
		int i =0;
		for(i=0; i<list.length; i++) {
			joined[i] = list[i];
		}
		joined[i] = value;
		return joined;
	}
}
