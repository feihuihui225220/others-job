package com.anticw.agedq.bed;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.MessagePack;  


public  class MsgpackTest{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		  
		   MessagePack pack = new MessagePack();
		   byte[] content =new byte[]{(byte) 0xab,(byte) 0xcd,0x40,(byte) 0x97,(byte) 0x85,
				   (byte) 0xa1,0x64,(byte) 0x88,(byte) 0xa2,   0x62,0x72,0xc,(byte) 0xa2,
				   0x66,0x76,0x1,(byte) 0xa2,0x68,0x62,0x4c,(byte) 0xa2,0x6f,0x64,(byte) 0xff,
				   (byte) 0xa1,0x70,(byte) 0x92,0x6,0x9,(byte) 0xa2,0x73,0x74,(byte) 0xa2,0x6f,
				   0x6e,(byte) 0xa2,0x77,0x65,(byte) 0xff,(byte) 0xa2,0x77,0x74,(byte) 0xc3,
				   (byte) 0xa2,0x6d,0x61,(byte) 0xa2,0x48,0x54,(byte) 0xa2,0x6d,0x6f,(byte) 0xa2,
				   0x30,0x32,(byte) 0xa2,0x73,0x6e,(byte) 0xa6,0x5a,0x35,0x30,0x30,0x30,0x31,
				   (byte) 0xa1,0x76,0x2};
		   //序列化
		    //反序列化
		   getMMattress(content);
		}

	 public static void getMMattress(byte[] content) throws IOException{
		 byte[] bytes = new byte[1];
         bytes[0] = 0x40;
         String hb="",br="", od="", p="", st="", we="", wt="", ma="", mo="", sn="", v="",fv="",dp="";
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
                     System.out.println(value_);
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
                    dp = value_ == "195" ? "1" : "0";;
                    break;
                case "fv":
                 fv = value_;
                 break;
                case "hb":
                 hb = value_;
                break;
                 case "br":
                 br = value_;
                break;
                case "od":
                od = value_ == "255" ? "-1" : value_;
                break;
                case "p":
                p = value_;
                break;
                case "st":
                st = value_;
                break;
                case "we":
                we = value_ == "255" ? "-1" : value_;
                break;
                case "wt":
                wt =  value_ == "195" ? "1" : "0";;
                break;
                case "ma":
                ma = value_;
                break;
                case "mo":
                mo = value_;
                break;
                case "sn":
                sn = value_;
                break;
                case "v":
                v = value_;
                break;

            }
             }
        	  
         }
         System.out.println("|| ma:" +ma + "|| mo:" + mo + "|| sn:" + sn + "|| v:" + v + "|| br:" + br + "|| fv:" + fv + "|| hb:" + hb + "|| od:" + od + "|| p:" + p + "|| st:" + st + "|| we:" + we + "|| wt:" + wt);
	 }
 }
  

