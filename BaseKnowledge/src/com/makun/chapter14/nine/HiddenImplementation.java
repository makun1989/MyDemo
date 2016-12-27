package com.makun.chapter14.nine;

import java.lang.reflect.Method;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception{
		A a=HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		callHiddenMethod(a,"g");
		callHiddenMethod(a,"u");
		callHiddenMethod(a,"v");
		callHiddenMethod(a,"w");
	}
	
	static void callHiddenMethod(Object a,String methodName) throws Exception{
		Method method=a.getClass().getDeclaredMethod(methodName);
		method.setAccessible(true);
		method.invoke(a);
	}
}

class C implements A {

	@Override
	public void f() {
		System.out.println("public C.f()");

	}

	@Override
	public void g() {
		System.out.println("public C.g()");

	}

	void u() {
		System.out.println("package C.u()");
	}

	protected void v() {
		System.out.println("protected C.v()");
	}

	private void w() {
		System.out.println("private C.w()");
	}

}

class HiddenC {
	public static A makeA() {
		return new C();
	}
}