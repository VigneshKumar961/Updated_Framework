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

import pageObjects.Archivalwindow;
import resources.base;

public class Homepage extends base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		System.out.println("Browser Initialized");
		log.info("Logged");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
   
	
	@Test
	public void windowCreation()
	{
		try {
		Archivalwindow aw = new Archivalwindow(driver);
		aw.getUsername().sendKeys("vignesh");
		aw.getPassword().sendKeys("vignesh");	
		aw.Submitbutton().click();
		aw.Configuration().click();
		aw.Window().click();
		WebElement StaticDropdown = aw.Sourcesystem();
		Select dropdown = new Select(StaticDropdown);
		dropdown.selectByVisibleText("BRM");
		String Uid = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").
				format(Calendar.getInstance().getTime());
		aw.Vodaticket().sendKeys(Uid);
		aw.Fromdate().click();
		List<WebElement> datepicker = aw.Allmonths();
		
//		int datepicker1 = datepicker.size();
		
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
	    String Currentdate = Sysdate.replaceAll("^0*", "");
	    
	    System.out.println(Currentdate);
	    System.out.println(Currentmonth);
	    System.out.println(Currenttime);
		
	    int datepicker1 = datepicker.size();
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
		List<WebElement> datebox = aw.Alldates();
		
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
		
		aw.Todate().click();
		
		try {
		List<WebElement> datepicker01 = aw.Tomonths();
		
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
			List<WebElement> datebox2 = aw.Datebox2();
			
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
		
		aw.Radiobtn().click();
		aw.Dailytime().click();
		aw.Dailytime().sendKeys(Currenttime);
		aw.Dailytotime().sendKeys("11:57:59");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		aw.Bodyclick().click();
		aw.Addbutton().click();
		//js.executeScript("window.scrollBy(0,-800)");
		//aw.Windowsubmit().click();
		}catch(NullPointerException e)
		{
			System.out.print("NullPointerException caught");
		}
		
	}
		
	
    
	
  /* @AfterTest
   public void teardown() 
   {
	   driver.close();
   }*/


	

}
