package com.makun.champter5;

public class TerminationCondition {
	public static void main(String[] args) {
		Book book =new Book(true);
		book.checkIn();
		new Book(true);
		System.gc();
	}
}

class Book {
	boolean checkout = false;
	Book(boolean checkout){
		this.checkout =checkout ;
	}
	void checkIn(){
		checkout = false;
	}
	
	@Override
	protected void finalize(){
		if(checkout ){
			System.out.println("Error : check out");
			
		}
	}
}
