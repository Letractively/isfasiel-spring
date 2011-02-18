package com.isfasiel.util.thread;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TreadScope implements Scope {

	private final ThreadLocal threadScope = new ThreadLocal() {
		@Override
		protected Object initialValue() {
			return new HashMap();
		}
	};
	
	@Override
	public Object get(String name, ObjectFactory objectFactory) {
		Map scope = (Map) threadScope.get();
		Object object = scope.get(name);
		if(object == null) {
			object = objectFactory.getObject();
			scope.put(name, object);
		}
		return object;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object remove(String name) {
		Map scope = (Map) threadScope.get();
		return scope.remove(name);
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return "";
	}
}
