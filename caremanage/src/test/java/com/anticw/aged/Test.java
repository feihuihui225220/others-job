package com.anticw.aged;

public class Test {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10000; i++) {
			if (i%2 == 1 && i%3 == 1  && i%4 == 1  && i%5 == 1  && i%6 == 1  
					&& i%7 == 1  && i%11 == 0   ) {
				count++;
				System.out.print(i+"  ");
				if (count%10 == 0) {
					System.out.println("\n");
				}
			}
		}
	}

}
