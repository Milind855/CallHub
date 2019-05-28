package com.org.callhub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.model.Schedule;



public class LoginPage 
{
	static WebDriver driver;
	static String SMSJObName="SMS"+Math.random();
	static Properties prop;
	static Date date =new Date();
	static int d=date.getDate();

	
	public static void LoadProperties() throws FileNotFoundException, IOException 
	{
	    prop=new Properties();
//		prop.load(new FileInputStream("C:\\Users\\milind.kulkarni\\eclipse-workspace\\EspProject\\src\\main\\java\\Config.properties"));
		InputStream is = LoginPage.class.getResourceAsStream("/Config.properties");
		if(is != null)
			prop.load(is);
		System.out.println("IS:"+is);
		
	}
	@BeforeSuite
	public static WebDriver BeforeTestRun() throws FileNotFoundException, IOException
	{
		LoginPage.LoadProperties();
		driver=LoginUtility.BeforeTestRun(driver);
		return driver;
	}
	
	@Test
	public static void Login() throws InterruptedException 
	{
		com.model.Login.UserId(driver).sendKeys("mkmilindk4@gmail.com");
		com.model.Login.Next(driver).click();
		Thread.sleep(2000);
	
	}
	@Test(dependsOnMethods= {"Login"})
	public static void LoginSign() throws InterruptedException
	{
		Thread.sleep(2000);
		com.model.Login.password(driver).sendKeys("milind.123");
		com.model.Login.SignUp(driver).click();
		//Schedule.GetStarted(driver).click();
		Thread.sleep(2000);
		Schedule.VoiceSMS(driver).click();
		Thread.sleep(2000);
		Schedule.TextToSpeech(driver).click();
		Thread.sleep(2000);
		Schedule.Next(driver).click();
		String str="Enter text to be spoken when a person answers the phone";
		String str1=Schedule.ErrorText(driver).getText();
		Assert.assertEquals(str, str1);
		Thread.sleep(2000);
		Schedule.TextArea(driver).clear();
		Schedule.TextArea(driver).sendKeys("Hello{first_name}");
		Thread.sleep(2000);
		//driver.close();
		Thread.sleep(2000);
		
	}
	
	
	@Test(dependsOnMethods= {"Login","LoginSign"})
	public static void Voice() throws InterruptedException 
	{
		Schedule.Enable_machine(driver).click();
		Thread.sleep(2000);
		Schedule.Enable_machine_HangUp(driver).click();
		Thread.sleep(2000);
		Schedule.Enable_DoNotCall(driver).click();
		Thread.sleep(2000);
		Schedule.Enable_DoNotCall_TextToSpeech(driver).click();
		Thread.sleep(2000);
		Schedule.Enable_DoNotCall_TextArea(driver).sendKeys("Hello Caller");
		Thread.sleep(2000);
		Schedule.Next(driver).click();
		Thread.sleep(2000);
		Schedule.Contact_TextField(driver).click();
		Thread.sleep(2000);
		Schedule.Contact_TextSelect(driver).click();
		Thread.sleep(2000);
		Schedule.Next(driver).click();
		Thread.sleep(2000);
		Schedule.Next(driver).click();
		//Thread.sleep(2000);
		//Schedule.Next(driver).click();
		Thread.sleep(2000);
		
		Schedule.StartDate(driver, d);
		Thread.sleep(2000);
		Schedule.Next(driver).click();
		Thread.sleep(2000);
		
		driver.close();
	}
	

}
