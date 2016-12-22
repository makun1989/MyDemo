package com.makun.chapter14;


//证明类的加载是运行时动态加载的.
public class SweetShop {
	public static void main(String[] args) {
		System.out.println("starting main.");
		new Candy();
		System.out.println("after loading new candy.");
		try {
			Class.forName("com.makun.chapter14.Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Gum not found");
		}
		System.out.println("after forname gum");
		new Cookie();
	}
}

class Candy{
	static{
		System.out.println("load Candy");
	}
}
class Gum{
	static{
		System.out.println("load Gum");
	}
}
class Cookie{
	static{
		System.out.println("load Cookie");
	}
}


