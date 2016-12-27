package com.makun.chapter14.nine;

public class AnonymousImplementation {
	public static void main(String[] args) throws Exception{
		A a =AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}

}

class AnonymousA {
	static A makeA() {
		return new A() {
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
		};
	}
}