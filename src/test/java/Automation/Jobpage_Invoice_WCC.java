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

import pageObjects.Archivaljob;
import pageObjects.Archivalwindow;
import resources.base;

public class Jobpage_Invoice_WCC extends base {
	
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
	public void jobCreation()
	{
		
		Archivaljob aj = new Archivaljob(driver);
		aj.getUsername().sendKeys("vignesh");
		aj.getPassword().sendKeys("vignesh");	
		aj.Submitbutton().click();
		aj.Configuration().click();
		aj.Arcjob().click();
		log.info("Clicked");
		WebElement StaticDropdown = aj.Sourcesystem();
		Select dropdown = new Select(StaticDropdown);
		dropdown.selectByVisibleText("WCC");
		WebElement StaticDropdown1 = aj.Jobnm();
		Select dropdown1 = new Select(StaticDropdown1);
		dropdown1.selectByVisibleText("Invoice");
		WebElement StaticDropdown2 = aj.Jobtyp();
		Select dropdown2 = new Select(StaticDropdown2);
		dropdown2.selectByVisibleText("RECURRENT");
		WebElement StaticDropdown3 = aj.Prearchjobstp();
		Select dropdown3 = new Select(StaticDropdown3);
		dropdown3.selectByVisibleText("WITHIN ARCHIVAL WINDOW");
		
		aj.Fromdate().click();
		List<WebElement> datepicker = aj.Allmonths();
		
		int datepicker1 = datepicker.size();
		
		Date date = new Date(System.currentTimeMillis());
		long Systime = date.getTime();
		Date time = new Date(Systime + (2 * 60 * 1000));
		String  newtime = time.toString();
		String[] Splittime = newtime.split(" ");
		String Currenttime = Splittime[3].trim();
		System.out.println(date);
		String Fd = date.toString();
		String[] Splitdate = Fd.split(" ");
	    String Currentmonth = Splitdate[1].trim();
	    String Sysdate = Splitdate[2].trim();
	    String Currentdate = Sysdate.replaceAll("^0*", ""); /*need to debug this line next month start*/
	    
	    System.out.println(Currentdate);
	    System.out.println(Currentmonth);
	    System.out.println(Currenttime);
		
		for(int i=0;i<datepicker1;i++)
	    {
	    	String months = datepicker.get(i).getText();
	    	
	    	if(months.equalsIgnoreCase(Currentmonth))
	    	{
	    		datepicker.get(i).click();
	    		break;
	    	}
	   
	    }
		
		try {
		List<WebElement> datebox = aj.Alldates();
		
		int datebox1 = datebox.size();
		
		for(int i=0;i<datebox1;i++) 
		{
			String db = datebox.get(i).getText();
			
			if(db.equalsIgnoreCase(Currentdate)) 
			{
				datebox.get(i).click();			
			}
		}
		}catch(StaleElementReferenceException e) {
			
		}
		
		aj.Todate().click();
		
		try {
		List<WebElement> datepicker01 = aj.Tomonths();
		
		int datepicker02 = datepicker01.size();
		
		for(int i=0;i<datepicker02;i++)
	    {
	    	String monthsbox = datepicker01.get(i).getText();
	    	
	    	if(monthsbox.equalsIgnoreCase(Currentmonth))
	    	{
	    		datepicker01.get(i).click();
	    		break;
	    	}
	   
	    }
		
		
	}catch(StaleElementReferenceException e) {
		
	}
		
		try {
			List<WebElement> datebox2 = aj.Datebox2();
			
			int datebox01 = datebox2.size();
			
			for(int i=0;i<datebox01;i++) 
			{
				String db = datebox2.get(i).getText();
				
				if(db.equalsIgnoreCase(Currentdate)) 
				{
					datebox2.get(i).click();			
				}
			}
			}catch(StaleElementReferenceException e) {
				
			}	
		
		aj.Radiobtn().click();
		aj.Dailytime().click();
		aj.Dailytime().sendKeys(Currenttime);
		aj.Dailytotime().sendKeys("11:57:59");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		aj.Bodyclick().click();
//		aj.Addbutton().click();
	}
}