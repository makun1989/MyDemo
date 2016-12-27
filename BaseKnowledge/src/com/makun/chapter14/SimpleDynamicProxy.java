package com.makun.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("boboob");
	}
	public static void main(String[] args) throws Throwable{
		RealObject realObj=new RealObject();
		consumer(realObj);
		Interface proxy=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObj));
		consumer(proxy);
	}
}

interface Interface{
	void doSomething();
	void somethingElse(String str);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		System.out.println("do something:");
	}

	@Override
	public void somethingElse(String str) {
		System.out.println("something else:"+str);
	}
	
}

class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object proxied){
		this.proxied=proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("*** proxy:"+proxy.getClass()+",method:"+method+",args:"+args);
		if(args!=null){
			for(Object obj:args){
				System.out.println(" "+obj);
			}
		}
		return method.invoke(proxied, args);
	}
}