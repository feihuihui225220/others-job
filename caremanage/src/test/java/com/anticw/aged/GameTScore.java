package com.anticw.aged;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anticw.aged.bean.GGameT;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.game.GameTService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml",
		"classpath:/spring/webApplicationContext.xml" })
public class GameTScore {

	@Autowired
	private RUserService ruserServer;
	@Autowired
	private GameTService gameTService;
	static Double[]  primary_11={(double)0,(double)21,(double)2,(double)17,(double)3,(double)29,(double)4,(double)44,(double)5,(double)55,(double)6,(double)64,(double)7,(double)72,(double)8,(double)72,(double)9,(double)72};
	static Double[]  middle_11={(double)0,(double)21,(double)2,(double)22,(double)3,(double)31,(double)4,(double)42,(double)5,(double)52,(double)6,(double)60,(double)7,(double)66,(double)8,(double)72,(double)9,(double)72};
	static Double[]  high_11={(double)0,(double)21,(double)2,(double)21,(double)3,(double)30,(double)4,(double)39,(double)5,(double)49,(double)6,(double)57,(double)7,(double)63,(double)8,(double)69,(double)9,(double)74};
	static Double[]  university_11={(double)0,(double)21,(double)2,(double)25,(double)3,(double)33,(double)4,(double)41,(double)5,(double)52,(double)6,(double)59,(double)7,(double)63,(double)8,(double)67,(double)9,(double)72};
	
	static Double[]  primary_10={(double)7,(double)28,(double)8,(double)33,(double)9,(double)35,(double)10,(double)37,(double)11,(double)39,(double)12,(double)40,(double)13,(double)41,(double)14,(double)42,(double)15,(double)43,(double)16,(double)44,(double)17,(double)45,(double)19,(double)46,(double)21,(double)47,(double)23,(double)48,(double)26,(double)49,(double)28,(double)50,(double)29,(double)51,(double)30,(double)52,(double)32,(double)53,(double)33,(double)54,(double)34,(double)55,(double)36,(double)56,(double)37,(double)57,(double)38,(double)58,(double)39,(double)59,(double)40,(double)60,(double)41,(double)61,(double)42,(double)63,(double)44,(double)65,(double)45,(double)67,(double)47,(double)68,(double)48,(double)69,(double)56,(double)70,(double)63,(double)72,(double)64,(double)76};
	static Double[]  middle_10={(double)8,(double)25,(double)11,(double)28,(double)12,(double)30,(double)15,(double)33,(double)17,(double)35,(double)20,(double)36,(double)21,(double)37,(double)23,(double)38,(double)25,(double)40,(double)26,(double)41,(double)28,(double)42,(double)29,(double)43,(double)30,(double)44,(double)32,(double)45,(double)35,(double)47,(double)36,(double)48,(double)37,(double)50,(double)38,(double)51,(double)39,(double)53,(double)40,(double)54,(double)41,(double)56,(double)44,(double)57,(double)45,(double)58,(double)46,(double)59,(double)48,(double)61,(double)50,(double)64,(double)51,(double)65,(double)52,(double)68,(double)61,(double)75};
	static Double[]  high_10={(double)8,(double)26,(double)12,(double)30,(double)15,(double)33,(double)16,(double)35,(double)20,(double)36,(double)23,(double)37,(double)24,(double)38,(double)27,(double)40,(double)28,(double)41,(double)29,(double)42,(double)30,(double)43,(double)31,(double)44,(double)32,(double)45,(double)33,(double)46,(double)34,(double)47,(double)37,(double)49,(double)38,(double)50,(double)39,(double)51,(double)40,(double)52,(double)41,(double)53,(double)43,(double)54,(double)44,(double)55,(double)45,(double)56,(double)46,(double)58,(double)47,(double)59,(double)48,(double)60,(double)50,(double)61,(double)51,(double)62,(double)53,(double)64,(double)54,(double)65,(double)56,(double)69,(double)58,(double)74};
	static Double[]  university_10={(double)5,(double)28,(double)15,(double)32,(double)17,(double)34,(double)21,(double)35,(double)25,(double)37,(double)27,(double)38,(double)28,(double)39,(double)30,(double)40,(double)31,(double)42,(double)33,(double)43,(double)35,(double)46,(double)36,(double)47,(double)37,(double)48,(double)38,(double)49,(double)40,(double)51,(double)41,(double)52,(double)42,(double)53,(double)43,(double)54,(double)46,(double)55,(double)47,(double)56,(double)48,(double)58,(double)49,(double)59,(double)51,(double)60,(double)52,(double)61,(double)53,(double)62,(double)55,(double)64,(double)58,(double)66,(double)61,(double)68,(double)65,(double)72};
	
	static Double[]  primary_12={(double)0.00,(double)26,(double)0.50,(double)30,(double)0.67,(double)32,(double)0.83,(double)33,(double)1.00,(double)35,(double)1.17,(double)37,(double)1.33,(double)38,(double)1.50,(double)40,(double)1.67,(double)41,(double)1.84,(double)43,(double)2.00,(double)44,(double)2.17,(double)46,(double)2.33,(double)47,(double)2.34,(double)48,(double)2.50,(double)49,(double)2.67,(double)51,(double)2.83,(double)52,(double)3.00,(double)54,(double)3.17,(double)55,(double)3.33,(double)57,(double)3.50,(double)58,(double)3.67,(double)60,(double)3.83,(double)62,(double)4.00,(double)63,(double)4.17,(double)65,(double)4.33,(double)66,(double)4.67,(double)69,(double)4.84,(double)71};
    static Double[]  middle_12={(double)0.00,(double)24,(double)0.17,(double)26,(double)0.50,(double)29,(double)0.84,(double)32,(double)1.00,(double)33,(double)1.33,(double)36,(double)1.50,(double)37,(double)1.67,(double)39,(double)1.83,(double)40,(double)2.00,(double)42,(double)2.17,(double)43,(double)2.33,(double)44,(double)2.50,(double)46,(double)2.67,(double)47,(double)2.84,(double)49,(double)3.00,(double)50,(double)3.17,(double)51,(double)3.33,(double)53,(double)3.50,(double)54,(double)3.67,(double)56,(double)3.83,(double)57,(double)4.00,(double)59,(double)4.17,(double)60,(double)4.33,(double)61,(double)4.50,(double)63,(double)4.67,(double)64,(double)4.83,(double)66,(double)5.00,(double)67,(double)5.17,(double)69,(double)5.67,(double)73};
    static Double[]  high_12={(double)0.33,(double)22,(double)0.67,(double)25,(double)0.83,(double)27,(double)1.34,(double)31,(double)1.50,(double)33,(double)1.67,(double)34,(double)2.00,(double)38,(double)2.17,(double)39,(double)2.33,(double)41,(double)2.50,(double)42,(double)2.67,(double)44,(double)2.83,(double)45,(double)3.00,(double)47,(double)3.17,(double)48,(double)3.33,(double)50,(double)3.50,(double)52,(double)3.67,(double)53,(double)3.83,(double)55,(double)4.00,(double)56,(double)4.17,(double)58,(double)4.33,(double)59,(double)4.50,(double)61,(double)4.67,(double)62,(double)5.00,(double)66,(double)5.17,(double)67,(double)5.33,(double)69};
    static Double[]  university_12={(double)0.34,(double)27,(double)0.67,(double)30,(double)1.33,(double)36,(double)1.67,(double)38,(double)1.84,(double)40,(double)2.00,(double)41,(double)2.17,(double)42,(double)2.50,(double)45,(double)2.67,(double)46,(double)2.83,(double)48,(double)3.00,(double)49,(double)3.17,(double)51,(double)3.34,(double)52,(double)3.50,(double)53,(double)3.83,(double)56,(double)4.00,(double)57,(double)4.17,(double)59,(double)4.33,(double)60,(double)4.50,(double)62,(double)4.84,(double)64,(double)5.00,(double)66,(double)5.33,(double)68,(double)5.50,(double)70};

	static Double[]  primary_13={(double)0.00,(double)30,(double)0.25,(double)37,(double)0.50,(double)40,(double)0.75,(double)44,(double)1.00,(double)55};
	static Double[]  middle_13={(double)0.00,(double)32,(double)0.25,(double)37,(double)0.50,(double)40,(double)0.75,(double)44,(double)1.00,(double)55};
	static Double[]  high_13={(double)0.00,(double)30,(double)0.25,(double)33,(double)0.50,(double)36,(double)0.75,(double)41,(double)1.00,(double)53};
	static Double[]  university_13={(double)0.00,(double)32,(double)0.25,(double)36,(double)0.50,(double)40,(double)0.75,(double)44,(double)1.00,(double)55};
    
	static Double[]  primary_14={(double)0.00,(double)31,(double)0.25,(double)37,(double)0.50,(double)41,(double)0.75,(double)46,(double)1.00,(double)56};
	static Double[]  middle_14={(double)0.00,(double)32,(double)0.25,(double)36,(double)0.50,(double)41,(double)0.75,(double)46,(double)1.00,(double)56};
	static Double[]  high_14={(double)0.00,(double)35,(double)0.25,(double)40,(double)0.50,(double)43,(double)0.75,(double)48,(double)1.00,(double)57};
	static Double[]  university_14={(double)0.00,(double)32,(double)0.25,(double)36,(double)0.50,(double)39,(double)0.75,(double)44,(double)1.00,(double)54};
    
	static Double[]  primary_15={(double)0.17,(double)29,(double)0.21,(double)33,(double)0.25,(double)36,(double)0.29,(double)38,(double)0.33,(double)41,(double)0.38,(double)43,(double)0.46,(double)45,(double)0.50,(double)46,(double)0.54,(double)48,(double)0.58,(double)49,(double)0.63,(double)50,(double)0.67,(double)51,(double)0.71,(double)53,(double)0.75,(double)54,(double)0.79,(double)56,(double)0.83,(double)57,(double)0.88,(double)58,(double)0.92,(double)59,(double)0.96,(double)62,(double)1.00,(double)68};
	static Double[]  middle_15={(double)0.13,(double)25,(double)0.25,(double)29,(double)0.29,(double)31,(double)0.33,(double)33,(double)0.38,(double)35,(double)0.42,(double)37,(double)0.46,(double)38,(double)0.50,(double)40,(double)0.54,(double)41,(double)0.58,(double)42,(double)0.63,(double)43,(double)0.67,(double)44,(double)0.71,(double)45,(double)0.75,(double)46,(double)0.79,(double)48,(double)0.83,(double)50,(double)0.92,(double)54,(double)0.96,(double)59,(double)1.00,(double)66};
	static Double[]  high_15={(double)0.25,(double)26,(double)0.38,(double)32,(double)0.42,(double)35,(double)0.46,(double)37,(double)0.50,(double)38,(double)0.54,(double)40,(double)0.58,(double)42,(double)0.63,(double)43,(double)0.67,(double)44,(double)0.71,(double)45,(double)0.79,(double)46,(double)0.83,(double)49,(double)0.88,(double)51,(double)0.92,(double)52,(double)0.96,(double)55,(double)1.00,(double)62};
	static Double[]  university_15={(double)0.42,(double)30,(double)0.46,(double)34,(double)0.58,(double)35,(double)0.63,(double)37,(double)0.67,(double)38,(double)0.71,(double)39,(double)0.75,(double)40,(double)0.79,(double)42,(double)0.83,(double)45,(double)0.88,(double)48,(double)0.92,(double)50,(double)0.96,(double)54,(double)1.00,(double)61};
    
	static Double[]  primary_16={(double)0.13,(double)27,(double)0.17,(double)32,(double)0.21,(double)36,(double)0.25,(double)38,(double)0.29,(double)41,(double)0.33,(double)44,(double)0.38,(double)46,(double)0.42,(double)48,(double)0.46,(double)49,(double)0.50,(double)50,(double)0.54,(double)52,(double)0.58,(double)54,(double)0.63,(double)55,(double)0.67,(double)57,(double)0.71,(double)59,(double)0.75,(double)60,(double)0.79,(double)62,(double)0.83,(double)65,(double)0.92,(double)68,(double)0.96,(double)71,(double)1.00,(double)76};
	static Double[]  middle_16={(double)0.08,(double)25,(double)0.21,(double)30,(double)0.25,(double)34,(double)0.29,(double)36,(double)0.33,(double)38,(double)0.38,(double)41,(double)0.42,(double)43,(double)0.46,(double)44,(double)0.50,(double)45,(double)0.54,(double)46,(double)0.58,(double)47,(double)0.63,(double)50,(double)0.67,(double)52,(double)0.71,(double)55,(double)0.75,(double)57,(double)0.79,(double)59,(double)0.83,(double)61,(double)0.92,(double)64,(double)0.96,(double)67,(double)1.00,(double)73};
	static Double[]  high_16={(double)0.25,(double)28,(double)0.29,(double)32,(double)0.33,(double)34,(double)0.38,(double)36,(double)0.42,(double)38,(double)0.46,(double)40,(double)0.50,(double)42,(double)0.54,(double)44,(double)0.58,(double)46,(double)0.63,(double)48,(double)0.67,(double)51,(double)0.71,(double)53,(double)0.75,(double)55,(double)0.79,(double)57,(double)0.83,(double)59,(double)0.88,(double)60,(double)0.92,(double)64,(double)0.96,(double)65,(double)1.00,(double)70};
	static Double[]  university_16={(double)0.13,(double)28,(double)0.21,(double)33,(double)0.29,(double)36,(double)0.33,(double)39,(double)0.42,(double)41,(double)0.46,(double)42,(double)0.58,(double)44,(double)0.63,(double)46,(double)0.67,(double)47,(double)0.71,(double)49,(double)0.75,(double)52,(double)0.79,(double)53,(double)0.83,(double)55,(double)0.88,(double)56,(double)0.92,(double)58,(double)0.96,(double)62,(double)1.00,(double)70};
    
	static Double[]  primary_9={(double)0.28,(double)26,(double)0.32,(double)30,(double)0.40,(double)34,(double)0.44,(double)37,(double)0.48,(double)40,(double)0.52,(double)44,(double)0.56,(double)46,(double)0.60,(double)48,(double)0.64,(double)49,(double)0.68,(double)51,(double)0.72,(double)54,(double)0.76,(double)57,(double)0.80,(double)60,(double)0.84,(double)63,(double)0.88,(double)68,(double)0.92,(double)76};
	static Double[]  middle_9={(double)0.20,(double)27,(double)0.36,(double)31,(double)0.40,(double)33,(double)0.44,(double)35,(double)0.48,(double)37,(double)0.52,(double)38,(double)0.56,(double)39,(double)0.60,(double)41,(double)0.64,(double)43,(double)0.68,(double)45,(double)0.72,(double)48,(double)0.76,(double)52,(double)0.80,(double)57,(double)0.84,(double)61,(double)0.88,(double)66,(double)0.92,(double)75};
	static Double[]  high_9={(double)0.44,(double)30,(double)0.48,(double)35,(double)0.52,(double)38,(double)0.56,(double)39,(double)0.60,(double)41,(double)0.64,(double)44,(double)0.68,(double)46,(double)0.72,(double)49,(double)0.76,(double)52,(double)0.80,(double)55,(double)0.84,(double)59,(double)0.88,(double)63,(double)0.92,(double)68,(double)0.96,(double)74};
	static Double[]  university_9={(double)0.48,(double)32,(double)0.52,(double)38,(double)0.56,(double)41,(double)0.60,(double)43,(double)0.64,(double)46,(double)0.68,(double)48,(double)0.72,(double)49,(double)0.76,(double)50,(double)0.80,(double)52,(double)0.84,(double)56,(double)0.88,(double)61,(double)0.92,(double)65,(double)0.96,(double)70};
    @Test
	public void test() throws Exception {
			List<GGameT>  gg=gameTService.findGameTList();
			for(GGameT g:gg){
			RUser r=ruserServer.findById(Long.parseLong(g.getUserId()));
			System.out.println(r.getEducation());
			
			int education=0;
			if(r.getEducation()!=null){
				education=r.getEducation();
			}else{
				education=198;
			}
			Double score=Double.parseDouble(g.getScore());
			switch (g.getGameId()) {
			case 9:
				saveedut(g, education, score,get9());
				break;
			case 10:
				saveedut(g, education, score,get10());
				break;
			case 11:
				saveedut(g, education, score,get11());
				break;
			case 12:
				saveedut(g, education, score,get12());
				break;
			case 13:
				saveedut(g, education, score,get13());
				break;
			case 14:
				saveedut(g, education, score,get14());
				break;
			case 15:
				saveedut(g, education, score,get15());
				break;
			case 16:
				saveedut(g, education, score,get16());
				break;

			default:
				break;
			}
			}
		System.out.println("结束===================");
	}
    public static List<Double[]> get9(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
		arr_.add(primary_9);
		arr_.add(middle_9);
		arr_.add(high_9);
		arr_.add(university_9);
		return arr_;
    }
    public static List<Double[]> get10(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_10);
    	arr_.add(middle_10);
    	arr_.add(high_10);
    	arr_.add(university_10);
    	return arr_;
    }
    public static List<Double[]> get11(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_11);
    	arr_.add(middle_11);
    	arr_.add(high_11);
    	arr_.add(university_11);
    	return arr_;
    }
    public static List<Double[]> get12(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_12);
    	arr_.add(middle_12);
    	arr_.add(high_12);
    	arr_.add(university_12);
    	return arr_;
    }
    public static List<Double[]> get13(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_13);
    	arr_.add(middle_13);
    	arr_.add(high_13);
    	arr_.add(university_13);
    	return arr_;
    }
    public static List<Double[]> get14(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_14);
    	arr_.add(middle_14);
    	arr_.add(high_14);
    	arr_.add(university_14);
    	return arr_;
    }
    public static List<Double[]> get15(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_15);
    	arr_.add(middle_15);
    	arr_.add(high_15);
    	arr_.add(university_15);
    	return arr_;
    }
    public static List<Double[]> get16(){
    	List<Double[]> arr_=new ArrayList<Double[]>();
    	arr_.add(primary_16);
    	arr_.add(middle_16);
    	arr_.add(high_16);
    	arr_.add(university_16);
    	return arr_;
    }
    
	private void saveedut(GGameT g, int education, Double score,List<Double[]> arr) {
		
		if(education==200|education==201){//小学及以下
			for(int i=0;i<arr.get(0).length-2;i+=2){
				if(score>=arr.get(0)[i]&&score<arr.get(0)[i+2]){
					g.setEduT(arr.get(0)[i+1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score>=arr.get(0)[arr.get(0).length-2]){
					g.setEduT(arr.get(0)[arr.get(0).length-1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score<arr.get(0)[0]){
					g.setEduT(arr.get(0)[1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}
			}
		}else if(education==198|education==223|education==261){//初中
			for(int i=0;i<arr.get(1).length-2;i+=2){
				if(score>=arr.get(1)[i]&&score<arr.get(1)[i+2]){
					g.setEduT(arr.get(1)[i+1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score>=arr.get(1)[arr.get(1).length-2]){
					g.setEduT(arr.get(1)[arr.get(1).length-1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score<arr.get(1)[0]){
					g.setEduT(arr.get(1)[1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}
			}
		
		}else if(education==203|education==199 ){//高中、中专及职高
			for(int i=0;i<arr.get(2).length-2;i+=2){
				if(score>=arr.get(2)[i]&&score<arr.get(2)[i+2]){
					g.setEduT(arr.get(2)[i+1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score>=arr.get(2)[arr.get(2).length-2]){
					g.setEduT(arr.get(2)[arr.get(2).length-1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score<arr.get(2)[0]){
					g.setEduT(arr.get(2)[1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}
			}
		}else if(education==202|education==204|education==260 ){//大专本科及以上
			for(int i=0;i<arr.get(3).length-2;i+=2){
				if(score>=arr.get(3)[i]&&score<arr.get(3)[i+2]){
					g.setEduT(arr.get(3)[i+1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score>=arr.get(3)[arr.get(3).length-2]){
					g.setEduT(arr.get(3)[arr.get(3).length-1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}else if(score<arr.get(3)[0]){
					g.setEduT(arr.get(3)[1].intValue()+"");
					gameTService.updateGameT(g);
					break;
				}
			}
		}
	}
	
	

}
