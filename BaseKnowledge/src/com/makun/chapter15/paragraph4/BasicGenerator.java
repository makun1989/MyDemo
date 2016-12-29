package com.makun.chapter15.paragraph4;

public class BasicGenerator <T> implements Generator{
	private Class<T> type;
	
	public BasicGenerator(Class<T> type){
		this.type=type;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator(type);
	}
	
	public static void main(String[] args) {
		Generator<CountDe> generator = BasicGenerator.create(CountDe.class);
		for(int i=0;i<5;i++){
			System.out.println(generator.next());
		}
	}

}

class CountDe{
	private static int count =0;
	private final int id=count++;
	@Override
	public String toString() {
		return "count id:"+id;
	}
}




