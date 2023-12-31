package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Archivaljob {
	
	public WebDriver driver;
	
	public Archivaljob(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username = By.xpath("//input[@name='username']");
	By password = By.id("password");
	By submit = By.xpath("//button[@type='submit']");
	By configuration = By.xpath("//b[text()='Configuration']");
	By job = By.linkText("Archival Job");
    By Sourcesys = By.name("sourceSystemJob");
    By Jobname = By.name("jobName");
    By Jobtype = By.xpath("//select[@name='jobType']");
    By Jobsetup = By.name("jobSetup");
    By Fdate = By.name("fromDatePicker");
    By FMonths = By.xpath("//tbody/tr/td");
    By Dates = By.xpath("//div/table/tbody/tr/td");
    By Tdate = By.name("toDatePicker");
    By TMonths = By.xpath("//tbody/tr/td");
    By Todates = By.xpath("//div/table/tbody/tr/td");
    By Radiodaily = By.xpath("//input[@type='radio']");
    By Dailyftime = By.name("dailyFromTime");
    By Dailyttime = By.name("dailytoTime");
    By Click = By.xpath("//body");
    By Add = By.xpath("//button[text()='Add']");
    By Smtbtn = By.xpath("//button[text()='Submit']");
    
	
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement Submitbutton()
	{
		return driver.findElement(submit);
	}
	
	public WebElement Configuration ()
	{
		return driver.findElement(configuration);
	}
	
	public WebElement Arcjob ()
	{
		return driver.findElement(job);
	}
	
	public WebElement Sourcesystem ()
	{
		return driver.findElement(Sourcesys);
	}
	
	public WebElement Jobnm ()
	{
		return driver.findElement(Jobname);
	}
	
	public WebElement Jobtyp ()
	{
		return driver.findElement(Jobtype);
	}
	
	public WebElement Prearchjobstp ()
	{
		return driver.findElement(Jobsetup);
	}
	
	public WebElement Fromdate ()
	{
		return driver.findElement(Fdate);
	}	
	
	public List<WebElement> Allmonths ()
	{
		return driver.findElements(FMonths);
	}
	
	public List<WebElement> Alldates ()
	{
		return driver.findElements(Dates);
	}
	
	public WebElement Todate ()
	{
		return driver.findElement(Tdate);
	}
	
	public List<WebElement> Tomonths ()
	{
		return driver.findElements(TMonths);
	}
	
	public List<WebElement> Datebox2 ()
	{
		return driver.findElements(Todates);
	}
	
	public WebElement Radiobtn ()
	{
		return driver.findElement(Radiodaily);
	}
	
	public WebElement Dailytime ()
	{
		return driver.findElement(Dailyftime);
	}
	
	public WebElement Dailytotime ()
	{
		return driver.findElement(Dailyttime);
	}
	
	public WebElement Bodyclick ()
	{
		return driver.findElement(Click);
	}
	
	public WebElement Addbutton ()
	{
		return driver.findElement(Add);
	}
	
	public WebElement Windowsubmit ()
	{
		return driver.findElement(Smtbtn);
	}
	
}
