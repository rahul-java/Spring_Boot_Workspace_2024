package com.mea.core;

public class FI_LAMDA_Test {

	public static void main(String[] args) {

		Arithmetic ar=(int a,int b)->{
			int c=0;
			c=a+b;
			return c;
		};
		System.out.println(ar.add(10,20));
		System.out.println("-----------------------------------------");
		
		Arithmetic ar1=(int a,int b)->{
			return a+b;
		};
		System.out.println(ar1.add(10,20));
		System.out.println("-----------------------------------------");
		
		Arithmetic ar2=(int a,int b)->{return a+b;};
		System.out.println(ar2.add(10,20));
		System.out.println("-----------------------------------------");
		
		Arithmetic ar3=(int x,int y)-> x+y;
		System.out.println(ar3.add(100,200));
		System.out.println("-----------------------------------------");
		
		
	}

}
