package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;


import resources.base;

public class demo extends base {
	
	public WebDriver driver;
	static Logger log =LogManager.getLogger(base.class.getName());
	
	@Test
	public void initialize() throws IOException
	{
		
		driver = browserInitialization();
		System.out.println("Browser Initialized");
		log.trace("I am debugging the above line here");
		driver.get(prop.getProperty("url1"));
		driver.manage().window().maximize();
	}
	
		
		
}

