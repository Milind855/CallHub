package com.org.callhub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverObjectUtility
{
	
    private static WebDriverObjectUtility instanceOfSingletonClassExample = null;
    
    private WebDriver driver;
    
    private WebDriverObjectUtility()
    {
        System.out.println("WebDriver Singleton Object created.");
    }
     
    static Properties prop;
	
	
	
	public static void LoadProperties() throws FileNotFoundException, IOException 
	{
	    prop=new Properties();
		prop.load(new FileInputStream("C:\\Users\\milind.kulkarni\\eclipse-workspace\\CallhubVoice\\src\\main\\java\\Config.properties"));
		
	}

    public WebDriver openBrowser() throws FileNotFoundException, IOException{

    	WebDriverObjectUtility.LoadProperties();
    	driver=new ChromeDriver();
    	driver.get(prop.getProperty("url"));
    	driver.manage().window().maximize();
    	//TakeScreenShot.takescreenshot(driver, prop.getProperty("Snapshotpath"));
        return driver;
    }
    public static WebDriverObjectUtility getInstanceOfSingletonClassExample()
    {
        if (instanceOfSingletonClassExample == null)
        	instanceOfSingletonClassExample = new WebDriverObjectUtility();
       return instanceOfSingletonClassExample;
    }
    
   public static void main(String[] args) 
    {
    	WebDriverObjectUtility s1=WebDriverObjectUtility.getInstanceOfSingletonClassExample();
    	WebDriverObjectUtility s2=WebDriverObjectUtility.getInstanceOfSingletonClassExample();
    	
    	WebDriverObjectUtility s3=new WebDriverObjectUtility();
    	
    	System.out.println(s1);
    	System.out.println(s2);
    	System.out.println(s3);
    	
		
	}

}
