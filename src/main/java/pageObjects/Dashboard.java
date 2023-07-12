package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	public WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username = By.xpath("//input[@name='username']");
	By password = By.id("password");
	By submit = By.xpath("//button[@type='submit']");
	By Dashboard = By.xpath("//b[normalize-space()='Dashboard']");
	By Sourcesys = By.linkText("BRM");
	By job_id = By.name("jobId");
	By smtbtn = By.cssSelector("button[type='submit']");
    
	
	
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
		return driver.findElement(Dashboard);
	}
	
	public WebElement Sourcesystem ()
	{
		return driver.findElement(Sourcesys);
	}
	
	public WebElement Job_id ()
	{
		return driver.findElement(job_id);
	}
	
	public WebElement Smtbtn ()
	{
		return driver.findElement(job_id);
	}
	
}
