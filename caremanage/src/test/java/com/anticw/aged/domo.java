package com.anticw.aged;

import java.util.List;

public class domo {

	public static void main(String[] args) {
		Double[]  high_12={0.33,(double)22,(double)0.67,(double)25,(double)0.83,(double)27,(double)1.34,(double)31,(double)1.50,(double)33,(double)1.67,(double)34,(double)2.00,(double)38,(double)2.17,(double)39,(double)2.33,(double)41,(double)2.50,(double)42,(double)2.67,(double)44,(double)2,(double)83,(double)45,(double)3.00,(double)47,(double)3.17,(double)48,(double)3.33,(double)50,(double)3.50,(double)52,(double)3.67,(double)53,(double)3.83,(double)55,(double)4.00,(double)56,(double)4.17,(double)58,(double)4.33,(double)59,(double)4.50,(double)61,(double)4.67,(double)62,(double)5.00,(double)66,(double)5.17,(double)67,(double)5.33,(double)69};
			
		for(int i=0;i<high_12.length-2;i+=2){
			System.out.println(high_12[i]+"======"+high_12[i+1]+"==="+high_12[i+2]+"===="+i);
		}
		
	}
	public void get(List<Object> o){
		
	}
}
