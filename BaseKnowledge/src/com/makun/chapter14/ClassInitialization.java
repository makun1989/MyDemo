package com.makun.chapter14;

import java.util.Random;

public class ClassInitialization {
	public static Random rand=new Random(66);
	public static void main(String[] args)throws Exception {
		Class ini=Initable.class;
		System.out.println("After creating initable ref.");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staitcFinal2);
	}
}


class Initable{
	static final int staticFinal=47;
	static final int staitcFinal2=ClassInitialization.rand.nextInt(1000);
	static{
		System.out.println("Initializing Initable.");
	}
}

class Initable2{
	static final int staticNonFinal=147;
	static{
		System.out.println("Initializing Initable2.");
	}
}

class Initable3{
	static int staticNonFinal=73;
	static{
		System.out.println("Initializing Initable3.");
	}
}