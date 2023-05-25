package com.ibm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ibm.kafka.KafkaProducer1;

public class WebJiraUserDetails {

	
	public void sendUserNameToJira(String userName) {
		KafkaProducer1 kp = new KafkaProducer1(); 
		WebDriver driver; 
		// step 1 : load the driver
		System.setProperty("webdriver.chrome.driver", 
				"/Volumes/Kanchan/MyTrainings/ibm/ibm-kafka-may-2023/driver/chromedriver"); 
		driver = new ChromeDriver(); 
		
		// step 2 : load the url 
		String url = "https://id.atlassian.com/login";
		driver.get(url); 
		// step 3 : process the work on website (get the title of the page and give it to kafka) 
		String webSiteTitle = driver.getTitle(); 
		kp.postMessage(webSiteTitle); 
		
		
		//send user name to site 
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName); 
		kp.postMessage("User details sent " + userName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		driver.findElement(By.id("login-submit")).click(); 
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		
		// step 4 : close connection
		driver.close();
	}
}
