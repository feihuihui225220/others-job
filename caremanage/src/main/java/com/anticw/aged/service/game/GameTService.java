package com.anticw.aged.service.game;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.GGameT;
import com.anticw.aged.dao.game.GameTDao;
import com.anticw.aged.vo.common.DateParamVO;

/**
 * 作者：bsd
 * 日期：2016-8-29
 * 功能：TODO	
 */
@Service
public class GameTService {
	@Autowired
	private GameTDao gameTDao;
	
 
	public List<GGameT> findGameTByUserId(String userId){
		return gameTDao.findGameTByUserId(userId);
	}
	
 
	public List<GGameT> findGameTByGameId(int gameId){
		return gameTDao.findGameTByGameId(gameId);
	}
 
	public List<GGameT> findGameTByGameIdAndUserId(int gameId,String userId){
		return gameTDao.findGameTByGameIdAndUserId(gameId, userId);
	}
 
  
	public List<GGameT> findGameTList(){
		return gameTDao.findGameTList();
	}
 
 
	public Integer insertGameT(GGameT gameT){
		return gameTDao.insertGameT(gameT);	
	}
 
	public void updateGameT(GGameT gameT){
		 gameTDao.updateGameT(gameT);	
	}
	
	 
	public GGameT findGameTById(int id){
		return gameTDao.findGameTById(id);
	}
	
	public void delGGameTById(int id){
		gameTDao.delGGameTById(id);
	}
	public List<GGameT> findGameTByDate(int gameId,Date sDate,Date eDate){
		return gameTDao.findGameTByDate(gameId, sDate, eDate);
	
	}
	private static Logger logger = Logger.getLogger(Logger.class);  
	public  List<String>  htmlToWord2(int gameId,Date sDate,Date eDate) throws Exception {
		 List<String> list=new ArrayList<String>();
		 List<GGameT> ggame= this.findGameTByDate(gameId, sDate, eDate);
		 for(GGameT t:ggame){
			 try{
           //  InputStream cssIs = new FileInputStream("d:\\report.css");
             String body = t.getResultHtml();
             String css="#div{width:80%;}";
             body=body.replaceAll("<ul style=\"padding: 0 10px;height: 60px;list-style: none;\">", "");
             body=body.replaceAll("<li style=\"float: left;margin-right: 30px;list-style: none;\"><p>", "<li>");
             body=body.replaceAll("</p></li>", "</li>");
             body=body.replaceAll("<li>", "");
             body=body.replaceAll("<ul>", "");
             body=body.replaceAll("</li>", "");
             body=body.replaceAll("</ul>", ""); 
            // String css = this.getContent(cssIs);
             //拼一个标准的HTML格式文档
             String content = "<html><head><meta charset='utf-8' /><style>"+css+"</style></head><body>" + body + "</body></html>";
             FileOutputStream ostream = new FileOutputStream("d:\\media\\"+t.getId()+".doc"); 
             list.add("d:\\media\\"+t.getId()+".doc");
             InputStream is = new ByteArrayInputStream(content.getBytes("GBK"));
             POIFSFileSystem fs = new POIFSFileSystem();
             //对应于org.apache.poi.hdf.extractor.WordDocument
             fs.createDocument(is, "WordDocument");
             fs.writeFilesystem(ostream);
             is.close();
             ostream.flush();
             ostream.close();
           
			 }catch(Exception e){System.out.print("创建失败");}
			 logger.error("d:\\media\\"+t.getId()+".doc");
		 	}
		 // new File("d:\\"+t.getId()+".html").delete();
		return list;
         
      }
      
	/* public static void main(String[] args) throws Exception {
		 htmlToWord2();
	}*/
      /**
       * 把is写入到对应的word输出流os中
       * 不考虑异常的捕获，直接抛出
       * @param is
       * @param os
     * @return 
       * @throws IOException
       */
      @SuppressWarnings("unused")
	private static POIFSFileSystem inputStreamToWord(InputStream is) throws IOException {
         POIFSFileSystem fs = new POIFSFileSystem();
         //对应于org.apache.poi.hdf.extractor.WordDocument
         fs.createDocument(is, "WordDocument");
         return fs;
        
      }
      
      /**
       * 把输入流里面的内容以UTF-8编码当文本取出。
       * 不考虑异常，直接抛出
       * @param ises
       * @return
       * @throws IOException
       */
      @SuppressWarnings("unused")
	private static String getContent(InputStream... ises) throws IOException {
         if (ises != null) {
            StringBuilder result = new StringBuilder();
            BufferedReader br;
            String line;
            for (InputStream is : ises) {
               br = new BufferedReader(new InputStreamReader(is, "GBK"));
               while ((line=br.readLine()) != null) {
                   result.append(line);
               }
            }
            return result.toString();
         }
         return null;
      }
      /**
       * @author DX-2016/12/06
       * 获取个人一段时间之内游戏记录 
       * @param gameId
       * @param userId
       * @param paramVO
       * @return
       */
      public List<GGameT> findGameTByGameIdAndUserId(int gameId,String userId,DateParamVO paramVO){
  		return gameTDao.findGameTByGameIdAndUserId(gameId, userId,paramVO);
      }
      
}
