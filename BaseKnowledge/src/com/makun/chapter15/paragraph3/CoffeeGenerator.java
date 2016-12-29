package com.makun.chapter15.paragraph3;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> ,Iterable<Coffee>{
	
	private Class[] types={
		Americano.class,Breve.class,Cappuccino.class,Latte.class,Mocha.class	
	};
	
	private static Random rand=new Random(47);
	private int size=0;
	
	public CoffeeGenerator(){
		
	}
	
	public CoffeeGenerator(int sz){
		this.size=sz;
	}
	
	
	public static void main(String[] args) {
		CoffeeGenerator gen=new CoffeeGenerator();
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
		
		for(Coffee c : new CoffeeGenerator(5)){
			System.out.println(c);
			System.out.println();
		}
		
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	@Override
	public Coffee next(){
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count=size;

		@Override
		public boolean hasNext() {
			return size>0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	
	
}	
