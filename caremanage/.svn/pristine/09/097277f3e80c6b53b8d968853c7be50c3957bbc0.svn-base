package com.anticw.aged;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.dao.professional.activity.NProgramDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml",
		"classpath:/spring/webApplicationContext.xml" })
public class PTest_ {

	@Autowired
	private NProgramDao nProgramDao;

	@Test
	public void test() throws Exception {
		List<NProgram> npr=	nProgramDao.Lists();
		int i=1;
		for(NProgram n:npr){
			if(n.getAviUrl()!=null&&n.getAviUrl()!=""){
			        VideoThumbTaker videoThumbTaker = new VideoThumbTaker("H:\\workMyEclipse\\caremanager\\src\\main\\webapp\\WEB-INF\\tools\\ffmpeg.exe");
			        String url="C:/Users/DX-1992413/Desktop/img/beike"+i+".png";
			        try{
			            videoThumbTaker.getThumb("C:/Users/DX-1992413/Desktop/"+n.getAviUrl(), url,800, 600, 0, 0, 5);
			            System.out.println(url);
			        } catch (Exception e){
			            e.printStackTrace();
			        }
			        n.setCoverUrl("file/beike"+i+".png");
			        nProgramDao.update(n);
			        i++;
			}
			
		}
	}

}
