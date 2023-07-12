package Automation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.base;

public class SQL1 extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());

	
	@Test
	public void DBconnectivity()
	{
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.193.6:1521/DEVBRM","AP_BRM","brm123");
		System.out.println(con.toString());
		Statement s = con.createStatement();
		
		System.out.println("Connected");
		System.out.println("I am connected");
		ResultSet rs = s.executeQuery("select * from PIN.account_t where poid_id0='3640545'");
		
		
		
		while(rs.next()) {
			System.out.println("The account_no is " +rs.getString("account_no"));
			//System.out.println("The last_status_t is " + rs.getString("last_status_t"));
			driver = browserInitialization();
			System.out.println("Browser Initialized");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vignesh");
			driver.findElement(By.id("password")).sendKeys("vignesh");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//b[text()='Archival Search']")).click();
			driver.findElement(By.linkText("BRM")).click();
			driver.findElement(By.cssSelector("input[name='accountNO']")).sendKeys(rs.getString("account_no"));
		    break;
		}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	    
	}
}
