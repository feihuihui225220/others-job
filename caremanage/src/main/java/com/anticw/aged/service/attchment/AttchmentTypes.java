package com.anticw.aged.service.attchment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.anticw.aged.vo.attchment.AttTypeVO;

/**
 * 上传附件的类型及相对路径管理
 * <P>File name : AttchmentTypes.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-9-28 </P>
 */
@Service
public class AttchmentTypes implements InitializingBean {
	
	/**
	 * 配置文件路径
	 */
	private static final String FILE_PATH = "/config/attchment.xml";
	
	/**
	 * 附件类型映射
	 */
	private Map<Integer, AttTypeVO> attMap = new HashMap<Integer, AttTypeVO>();
	
	/**
	 * 初始化
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-9-28 </P>
	 * @throws Exception
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		initAttTypes();
	}
	
	/**
	 * 初始化配置文件获取附件类型信息
	 * AttchmentTypes.initAttTypes()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-9-28 </P>
	 */
	private void initAttTypes(){
		
		//解析XML
		Document doc;
		SAXBuilder builder = new SAXBuilder();
		try{
			doc = builder.build(AttchmentTypes.class.getResourceAsStream(FILE_PATH));
			Element root = doc.getRootElement();
			List<Element> codes = root.getChildren("att");
			for(Iterator<Element> iter = codes.iterator(); iter.hasNext();){
				Element att = iter.next();
				AttTypeVO vo = new AttTypeVO();
				vo.setId(Integer.parseInt(att.getAttributeValue("id")));
				vo.setName(att.getAttributeValue("name"));
				vo.setUri(att.getAttributeValue("uri"));
				attMap.put(vo.getId(), vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据code获取URI
	 * AttchmentTypes.getAttURI()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-9-28 </P>
	 * @param code
	 * @return
	 */
	public String getAttURI(int code, String...parameters) {
		AttTypeVO attVo = attMap.get(code);
		if(attVo == null) {
			return null;
		} else {
			if(parameters.length > 0) {
				return attVo.getUri().replaceAll("\\{(.*)\\}", parameters[0]);
			} else {
				return attVo.getUri();
			}
		}
	}
}
