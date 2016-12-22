package com.makun.champter10.interfaceDe;

public interface Contents {
	int value();
	
	class StaticInner{
		public String getStr(){
			return "michael";
		}
		public static void main(String[] args) {
			StaticInner inner =new StaticInner();
			inner.getStr();
		}
	}
}
