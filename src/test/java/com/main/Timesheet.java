package com.main;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.LoginPage;
import genericUtility.ExcelUtility;
import utililty.BaseClass;
import utililty.JavaUtility;
import utililty.PropertyUtility;
import utililty.WebdriverUtility;


@Listeners(genericUtility.ListenerImplementation.class)

public class Timesheet extends BaseClass {
	
	@Test(groups="SmokeTest")
		public void Timesheet() throws Throwable {
        //type1(Browser Launching)
		//WebDriver driver=new EdgeDriver();
		/*driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		*/
		
		WebdriverUtility wb= new WebdriverUtility();
		wb.implicity_wait(driver);
		
		PropertyUtility proutil1=new PropertyUtility() ;
		String URL = proutil1.getKeyValue("url");
		String USERNAME = proutil1.getKeyValue("username");
		String PASS = proutil1.getKeyValue("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginData(USERNAME, PASS);
		Thread.sleep(1000);

    	driver.findElement(By.xpath("(//div[@class='menu_icon'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		JavaUtility ju=new JavaUtility();
		int ranno=ju.getRanDomNum();
		
		Thread.sleep(1000);
		ExcelUtility eu=new ExcelUtility();
		String exceldata = eu.getExcelDataByFormatter("Sheet1", 1, 0)+ranno;
		driver.findElement(By.id("name")).sendKeys(exceldata);
		//driver.findElement(By.xpath("//input[@value='   Create Type of Work   ']")).click();
		driver.findElement(By.xpath("//input[@onclick='handleCancel();']")).click();
  	   wb.getAlertAccept(driver);


		
		
      
	}

}
