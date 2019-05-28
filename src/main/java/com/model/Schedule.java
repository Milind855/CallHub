package com.model;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Schedule {

	static WebDriver driver;
	static WebElement element;
	Properties pro=new Properties();
	
	
	public static WebElement GetStarted(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[text()='Get Started']"));
		return element;
	}
	
	public static WebElement VoiceSMS(WebDriver driver)
	{
		element=driver.findElement(By.xpath("/html/body/section/div[3]/div/div/div[2]/div[1]/div[2]/div[2]/div/a"));
		return element;
	}
	
	public static WebElement TextToSpeech(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_live-section_type_0']/parent::label/i"));
		return element;
	}
	
	
	public static WebElement TextArea(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_live-section_type_0']/parent::label/textarea"));
		return element;
	}
	
	
	public static WebElement Next(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[@id='wizard-next']"));
		return element;
	}
	
	public static WebElement ErrorText(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[text()='Enter text to be spoken when a person answers the phone']"));
		return element;
	}
	
	public static WebElement Enable_machine(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[text()='Enable Answering Machine Detection']"));
		return element;
	}
	public static WebElement Enable_machine_HangUp(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_voicemail_choice_0']/parent::label/i"));
		return element;
	}
	
	public static WebElement Enable_DoNotCall(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[text()='Enable Do Not Call']"));
		return element;
	}
	
	public static WebElement Enable_DoNotCall_TextArea(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_dnc-section_type_0']/parent::label/textarea"));
		return element;
	}
	
	public static WebElement Enable_DoNotCall_TextToSpeech(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_dnc-section_type_0']/parent::label/i"));
		return element;
	}
	
	public static WebElement Contact_TextField(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@role='textbox']"));
		return element;
	}
	
	public static WebElement Contact_TextSelect(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//li[text()='BlackPearl']"));
		return element;
	}
	
	
	public static void StartDate(WebDriver driver,int date) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='id_startingdate']")).click();
		Thread.sleep(1000);
		
		String Date=date+1+"";
		//String StartDate=Date+"";
		boolean staleElement = true; 
		int count=0;
		while(staleElement){
		  try{
				List<WebElement> allDates=driver.findElements(By.xpath("/html/body/div[7]"));
				
				int total_date=allDates.size();
				for (int i=0; i<total_date; i++){
					
					String s=allDates.get(i).getText();
					
				    if(s.equalsIgnoreCase("1"))
				    {  
				    	for (int j=i; j<total_date; j++)
				    	{
				    	String s1=allDates.get(j).getText();
						if(s1.equalsIgnoreCase(Date))
							{
							allDates.get(j).click();
							
							break;
							}
				    	}
				    	break;
				    }
				    else
				    {
				    	continue;
				    }
					
				}
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
