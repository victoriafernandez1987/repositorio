package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigProp {
	static Properties prop = new Properties();
	static InputStream input = null;
	
	private static void init(){
		try {
			input = new FileInputStream("src/main/resources/config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static String getByKey(String key){
//		return prop.getProperty(key);
//	}

	public static String getChromePath(){
		return prop.getProperty("chromePath");	
	}
	
	public static String getUrl(){
		return prop.getProperty("url");	
	}
	
	public static String getBrowser(){
		init();
		return prop.getProperty("browser");		
	}
	
	public static String getPlatform() {
		return prop.getProperty("platform");
	}

}
