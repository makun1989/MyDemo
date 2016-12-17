package com.makun.champter5;

public class EnumDemo {
	public static void main(String[] args) {
		// Week[] values = Week.values();
		//
		// for(Week week:values){
		// System.out.println(week.toString());
		// int ordinal = week.ordinal();
		// System.out.println(ordinal);
		// }

		Money[] values = Money.values();
		for (Money money : values) {
			System.out.println(money.getMoney());
			System.out.println(money.ordinal());
		}

		switch (Money.Mon50) {
		case Mon1:
			System.out.println("用来买点好吃的糖");
			break;
		case Mon5:
			System.out.println("用来买点白菜");
			break;
		case Mon10:
			System.out.println("巧克力有指望了");
			break;
		case Mon20:
			System.out.println("我回去买点牛肉");
			break;
		case Mon50:
			System.out.println("买龙虾吃啊");
			break;
		case Mon100:
			System.out.println("不知道怎么花了");
			break;
		default:
			System.out.println("你确定给我钱了?");

		}
	}
}

enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUDAY;
}

enum Money {
	Mon1(1), Mon5(5), Mon10(10), Mon20(20), Mon50(50), Mon100(100);

	private int money;

	Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
