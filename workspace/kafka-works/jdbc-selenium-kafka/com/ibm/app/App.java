package com.ibm.app;

import java.util.List;

import com.ibm.db.User;
import com.ibm.db.UserDAO;
import com.ibm.kafka.KafkaProducer1;
import com.ibm.selenium.WebJiraUserDetails;

public class App {
	
	public static void main(String[] args) {
		// get all the records from dbms 
		// give it to kafka producer 
		
		
		List<User> allUsers = new UserDAO().getAllUsers(); 
		KafkaProducer1 kp = new KafkaProducer1(); 
		
		
		for(User user : allUsers) {
			
			kp.postMessage(user.getUserId() +", " + user.getUserName()); 
		}
		
		System.out.println("---------------- invoking selenium-----------");
		
		WebJiraUserDetails webPage = new WebJiraUserDetails(); 
		webPage.sendUserNameToJira("naveen@naveenks.com");
		
		
	}
}
