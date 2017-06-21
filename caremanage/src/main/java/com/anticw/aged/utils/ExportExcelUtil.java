/**
 * 
 */
package com.anticw.aged.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.pool.SpringDataPool;

/**
 * ExportExcel
 * @author guoyongxiang
 * Date: 2014-12-5
 */
public class ExportExcelUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ExportExcelUtil.class);
	private static SpringDataPool springDataPool = SpringContextHolder.getBean("springDataPool", SpringDataPool.class);
	
	/**
	 * @param <T>
	 * @param type
	 *            要导出的实体类
	 * @param sheetName
	 *            表 标签名称
	 * @param list
	 *            要导出的数据
	 * @param titles
	 *            导出的数据名称
	 * @param fieldNames
	 *            数据名称对应字段
	 * @param exportPath
	 *            导出的路径
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static <T> void exportExcel(List<T> list, String sheetName, String[] titles, String[] fieldNames, HttpServletResponse response)
			throws Exception {
		OutputStream os = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String name = sdf.format(new Date());
			// 组装请求
			os = response.getOutputStream();
			response.reset();
			
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
			
			WritableWorkbook wbook = Workbook.createWorkbook(os); // 建立excel文件
			WritableSheet wsheet = wbook.createSheet(sheetName, 0); // 工作表名称
			// 设置Excel字体
			WritableFont wfont = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD, false,
					jxl.format.UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			WritableCellFormat titleFormat = new WritableCellFormat(wfont);
			String[] title = titles;
			// 设置Excel表头
			for (int i = 0; i < title.length; i++) {
				Label excelTitle = new Label(i, 0, title[i], titleFormat);
				wsheet.addCell(excelTitle);
			}
			int c = 1; // 用于循环时Excel的行号
			Iterator<T> it = list.iterator();
			int count = 0;
			while (it.hasNext()) {
				try {
					T t = (T) it.next();
					Class<? extends Object> type = t.getClass();
					// 通过类实体找到所有成员变量
					Field fields[] = type.getDeclaredFields();
					for (int i = 0; i < fieldNames.length; i++) {
						String feildName = fieldNames[i];
						for (Field field : fields) {
							// 找到需要导出成员变量
							if (field.getName().equals(feildName)) {
								// 获取属性的get方法名称
								String head = field.getName().toUpperCase().substring(0, 1);
								String getName = "get" + head + field.getName().substring(1);
								Method getMethod = type.getMethod(getName, new Class[] {});
								// 执行get方便
								Object result = getMethod.invoke(t,	new Object[] {});
								if (result instanceof Date) {
									Date date = (Date) result;
									result = sdf.format(date);
								}
								// 分类ID映射
								result = valMapping(feildName, result);
								
								Label contentName = new Label(i, c, result + "");
								wsheet.addCell(contentName);
							}
						}
					}
					c++;
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				++count;
			}
			wbook.write(); // 写入文件
			wbook.close();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("导出Excel异常sheetName：" + sheetName, e);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
	
	/**
	 * 导入excel
	 * @param in
	 * @return
	 */
	public static List<Object[]> importExcel(InputStream in){
		List<Object[]> rows = new ArrayList<Object[]>();
		try { 
            Workbook wb = Workbook.getWorkbook(in); 
            int wbNum = wb.getNumberOfSheets(); 
            for(int i = 0;i<wbNum;i++){ 
                Sheet sheet = wb.getSheet(i); 
               // String sheetName = sheet.getName(); 
                if(sheet!=null){ 
                    // 获取表格总列数 
                    int rsColumns = sheet.getColumns(); 
                    // 获取表格总行数 
                    int rsRows = sheet.getRows(); 
                    //循环文件里的数据
                    int startRows = 1;
                    for(int j=startRows;j<rsRows;j++){ 
                        Cell[] cells = sheet.getRow(j);
                        Object[] columns = new Object[rsColumns];
                        //List<Object> columns = new ArrayList<Object>();
                        for(int k=0;k<rsColumns;k++){ 
                            columns[k] = cells[k].getContents();
                        }
                        rows.add(columns);
                    } 
                } 
            } 
             
	    } catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
		return rows;
	}
	
	/** 映射字段列表 */
	private static String[] needMapping = {
		"gender","hrType","marry","political","education","lifeCond","jobCond",
		"medical","religion","nation","income"
	};
	/**
	 * 分类映射
	 * @author guoyongxiang
	 * Date: 2014-12-8 下午1:07:33
	 * @param feildName
	 * @param val
	 * @return
	 */
	private static Object valMapping(String feildName, Object val){
		List<String> mappingStr = Arrays.asList(needMapping);
		if(mappingStr.contains(feildName)){
			// 固定分类
			if("gender".equals(feildName)){
				if(val.equals(0)){
					return "女";
				}else if(val.equals(1)){
					return "男";
				}
			}else{
				// 动态分类
				OCategoryItem item = springDataPool.getOCategoryItem((Integer)val);
				if(item!=null){
					return item.getItemName();
				}
			}
		}
		return val;
	}
	
	
}
