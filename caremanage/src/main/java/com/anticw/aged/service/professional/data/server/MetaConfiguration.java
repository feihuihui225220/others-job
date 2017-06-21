package com.anticw.aged.service.professional.data.server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.anticw.aged.vo.professional.data.MetaConfigVO;

/**
 * 元服务配置类
 * <P>File name : MetaConfiguration.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-12 </P>
 */
public class MetaConfiguration {

	/**
	 * 配置文件的路径
	 */
	private final static String CONF_PATH = "/config/metadata.xml";

	/**
	 * 元服务配置集合
	 */
	private Map<String, MetaConfigVO> metaConfigMap = new HashMap<String, MetaConfigVO>();
	
	/**
	 * 构造函数
	 */
	public MetaConfiguration() {
		initConfig();
	}
	
	/**
	 * 初始化配置文件
	 * MetaConfiguration.initConfig()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 */
	private void initConfig() {
		
		//解析XML
		Document doc;
		SAXBuilder builder = new SAXBuilder();
		try{
			doc = builder.build(this.getClass().getResourceAsStream(CONF_PATH));
			Element root = doc.getRootElement();
			List<Element> metaServices = root.getChildren("meta-service");
			for(Iterator<Element> iter = metaServices.iterator(); iter.hasNext();){
				Element metaService = iter.next();
				MetaConfigVO vo = new MetaConfigVO(metaService.getChildTextTrim("id"), metaService.getChildTextTrim("beanName"), metaService.getChildTextTrim("class"));
				metaConfigMap.put(vo.getId(), vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取指定元服务的配置信息
	 * MetaConfiguration.getConfig()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-12 </P>
	 * @param id
	 * @return
	 */
	public MetaConfigVO getConfig(String id) {
		return metaConfigMap.get(id);
	}
}
