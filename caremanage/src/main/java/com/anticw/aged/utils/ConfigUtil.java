package  com.anticw.aged.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {
	private static final long RELOAD_PERIOD = 3 * 60 * 1000;
	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	private static ConfigUtil instance;
	private Properties props;
	private File file;
	private ConfigUtil() {
		instance = this;
		props = new Properties();
		try {
			String path = ConfigUtil.class.getClassLoader().getResource("//").getPath();
			file = new File(path+"config/config.properties");
			if(!file.exists()) {
				logger.error("初始化消息资源信息失败，["+file+"]文件不存在");
			}
			reload();
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						reload();
					} catch (IOException e) {
//						log.log(Level.WARNING, e.getMessage(), e);
						logger.error("重新加载资源文件失败"+e.getMessage());
					}
				}
			}, RELOAD_PERIOD, RELOAD_PERIOD);
		} catch (Exception e) {
//			log.log(Level.WARNING, e.getMessage(), e);
			logger.error("加载资源文件失败"+e.getMessage());
		}
		
	}
	private void reload() throws IOException {
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			is = new FileInputStream(file);
			bis = new BufferedInputStream(is);
			props.load(bis);
			logger.info("payment.properties 重新加载完成");
		} catch (Exception e) {
//			log.log(Level.WARNING, e.getMessage(), e);
			logger.error("重新加载资源文件失败"+e.getMessage());
		} finally {
			if(bis != null) bis.close();
			if(is != null) is.close();
		}
	}
	public static ConfigUtil getInstance() {
		if(instance == null) {
			new ConfigUtil();
		}
		return instance;
	}
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	public String getProperty(String key, Object... params) {
		return String.format(getProperty(key), params);
	}

	public static void main(String[] args) {
		/*while(true) {*/
			System.out.println(getInstance().getProperty("setFamiliarity"));
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		/*}*/
	}
}
