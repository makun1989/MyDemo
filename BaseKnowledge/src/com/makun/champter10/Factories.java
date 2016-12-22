package com.makun.champter10;

public class Factories {
	public static void factoryConsumer(ServiceFactory factory) {
		Service service = factory.getService();
		service.method1();
		service.method2();
	}

	public static void main(String[] args) {
		ServiceFactory factory1=Implemention1.factory;
		factoryConsumer(factory1);
	}

}

interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implemention1 implements Service {

	@Override
	public void method1() {
		System.out.println("Implements1 's method1");
	}

	@Override
	public void method2() {
		System.out.println("Implements1 's method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service getService() {

			return new Implemention1();
		}

	};
}

class Implemention2 implements Service {

	@Override
	public void method1() {
		System.out.println("Implements2 's method1");
	}

	@Override
	public void method2() {
		System.out.println("Implements2 's method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service getService() {

			return new Implemention2();
		}

	};
}
