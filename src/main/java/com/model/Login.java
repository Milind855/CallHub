package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class Login 
{
	static WebDriver driver;
	static WebElement element;
	Properties pro=new Properties();
	
	public static WebElement UserId(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_user']"));
		return element;
	}
	
	public static WebElement Next(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[@id='change-btn-text']"));
		return element;
	}
	
	public static WebElement password(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='id_password']"));
		return element;
	}
	
	
	public static WebElement SignUp(WebDriver driver)
	{
		element=driver.findElement(By.id("change-btn-text"));
		return element;
	}
	
}
