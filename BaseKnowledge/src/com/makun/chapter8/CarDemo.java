package com.makun.chapter8;

public class CarDemo {
	public static void main(String[] args) {
		new RedCar();
	}
}


class Car{
	public Car(){
		System.out.println("before make car...");
		makeCar();
		System.out.println("after make car...");
	}
	public void makeCar(){
		System.out.println("I am making car...");
	}
}

class RedCar extends Car{
	
	int number;
	public RedCar(){
		number = 33;
	}
	public void makeCar(){
		System.out.println("I am making red car..." + number);
	}
}