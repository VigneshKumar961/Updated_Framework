package Automation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.util.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Database.MySQL1;
import pageObjects.Archivaljob;
import pageObjects.Archivalwindow;
import pageObjects.Dashboard;
import resources.base;

public class Dashboard_page extends base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		System.out.println("Browser Initialized");
		log.info("I am debugging the above line here");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
   
	
	@Test
	public void Dshbrdcreation()
	{
		
		Dashboard db = new Dashboard(driver);
		db.getUsername().sendKeys("vignesh");
		db.getPassword().sendKeys("vignesh");	
		db.Submitbutton().click();
		db.Configuration().click();
		log.info("Clicked");
		db.Sourcesystem().click();
	}

}
