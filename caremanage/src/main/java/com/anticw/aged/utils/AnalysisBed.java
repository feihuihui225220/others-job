package com.anticw.aged.utils;

import java.io.IOException;
import java.util.Arrays;

import org.msgpack.MessagePack;

import com.anticw.aged.bean.mongo.IntelligentMattress;

/**
 * 
 * @author DX-2016-5-23
 *
 */
public class AnalysisBed {
	
	
	public static IntelligentMattress getMMattress(byte[] content) throws IOException{
		 IntelligentMattress intel=new IntelligentMattress();
		 byte[] bytes = new byte[1];
         bytes[0] = 0x40;
         //获取有效数字长度
         int lenth = content[2];
         if (content.length >= lenth + 4){
        	 for (int i = 8; i < lenth + 4; i++)
             {
    		 	String value_ = "";
                String key_v=null;
                MessagePack pack = new MessagePack();
                byte[] byte11 = new byte[]{(byte) 0xa1,(byte) 0xa2,(byte) 0xa3,(byte) 0xa4,(byte) 0xa5,(byte) 0xa6,(byte) 0xa7};
                if (content[i]== byte11[0] || content[i] == byte11[1] || content[i] == byte11[2] || content[i] == byte11[3] || content[i] == byte11[4] || content[i] == byte11[5] || content[i] == byte11[6])
                { 
                //获取 下面的值
                     int leng = content[i] - (byte)0xa0;
                    key_v=pack.read(content, i, leng+1).toString();
                    //查找下一个 a
                    i = i+1 + leng;//下一个
                }
                if (content[i]== byte11[0] || content[i] == byte11[1] || content[i] == byte11[2] || content[i] == byte11[3] || content[i] == byte11[4] || content[i] == byte11[5] || content[i] == byte11[6])
                {
                	
                    //获取 下面的值
                    int leng = content[i] - (byte)0xa0;
                    byte temp[] = Arrays.copyOfRange(content, i+1, i+1+leng);
                     value_= new String(temp,"ascii");
                    i = i + leng;
                } else
                {
                    
                    if ((byte)content[i] == (byte)0x92)//9 是int 数组  长度 为2
                    {
                        value_ = "[" + ((int)content[i + 1]) + "," + ((int)content[i + 2]) + "]";
                        i = i + 2;
                    }
                    else
                    {
                    int sh = (int)content[i];
                    value_ = sh+"";
                    }
                   
                }
                
                key_v =  key_v.substring(0,key_v.length()-1);
                key_v =  key_v.substring(1,key_v.length());
                
                switch(key_v){
                    case "dp":
                    	intel.setDp(value_ == "195" ? "1" : "0");
                        break;
                    case "fv":
                    	intel.setFv(Integer.parseInt(value_));
                     break;
                    case "hb":
                    	intel.setHeartbeat(Integer.parseInt(value_));
                    break;
                     case "br":
                    	intel.setBreath(Integer.parseInt(value_));
                    break;
                    case "od":
                    	intel.setOdor(Integer.parseInt((value_ == "255" ? "-1" : value_)));
                    break;
                    case "p":
                    	intel.setPosition(value_);
                    break;
                    case "st":
                    	intel.setState(value_);
                    break;
                    case "we":
                    	intel.setWeight(Integer.parseInt((value_ == "255" ? "-1" : value_)));
                    break;
                    case "wt":
                    	intel.setWet(Integer.parseInt((value_ == "195" ? "1" : "0")));
                    break;
                    case "ma":
                    	intel.setMa(value_);
                    break;
                    case "mo":
                    	intel.setMo(value_);
                    break;
                    case "sn":
                    	intel.setSn(value_);
                    break;
                    case "v":
                    	intel.setV(Integer.parseInt(value_));
                    break;

                }
             }
         }
         return intel;
	 }
}
