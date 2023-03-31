package com.main;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import ObjectRepo.Login_Page;
import ObjectRepository.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.WebdriverUtility;

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
		Property_Utility proutil= new Property_Utility();
		
		WebdriverUtility wb= new WebdriverUtility();
		wb.implicity_wait(driver);
		
		String URL = proutil.getKeyValue("url");
		String USERNAME = proutil.getKeyValue("username");
		String PASS = proutil.getKeyValue("password");
		driver.get(URL);
		Login_Page lp=new Login_Page(driver);
		lp.loginData(USERNAME, PASS);
		Thread.sleep(1000);
		  

		/*String URL = proutil.getKeyValue("url");
		String USERNAME = proutil.getKeyValue("username");
		String PASS = proutil.getKeyValue("password");
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASS);
		driver.findElement(By.id("loginButton")).click();*/

    	driver.findElement(By.xpath("(//div[@class='menu_icon'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		Assert.assertEquals(true, true);

		Java_Utility ju=new Java_Utility();
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
