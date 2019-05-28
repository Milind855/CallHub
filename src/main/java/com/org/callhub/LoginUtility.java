package com.org.callhub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class LoginUtility
{
	static Date date =new Date();
	static int d=date.getDate();
	//static WebDriver driver;
	static String SMSJObName="Hello"+Math.random();
	static Properties prop;
	
	
	
	public static void LoadProperties() throws FileNotFoundException, IOException 
	{
	    prop=new Properties();
		//prop.load(new FileInputStream("C:\\Users\\milind.kulkarni\\eclipse-workspace\\CallhubVoice\\src\\main\\java\\Config.properties"));
		
	    
	    InputStream is = LoginPage.class.getResourceAsStream("/Config.properties");
		if(is != null)
			prop.load(is);
		System.out.println("IS:"+is);
	}
	
	public static WebDriver BeforeTestRun(WebDriver driver) throws FileNotFoundException, IOException
	{
		LoginUtility.LoadProperties();
		String name=prop.getProperty("user");
		System.out.println(name);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("webdriver.chrome.driver"));
		WebDriverObjectUtility obj=WebDriverObjectUtility.getInstanceOfSingletonClassExample();
		driver=obj.openBrowser();
		System.out.println(driver);
		return driver;
	}
	
	
	
	
	
	
	

}
