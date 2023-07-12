package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import resources.base;

public class MySQL1 extends base{

	
		@Test
		public void windowCreation1() {
		
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://10.78.194.251:3306/anp_gdpr_schema","anp_gdpr","anp_gdpr");
		System.out.println(con.toString());
		Statement s = con.createStatement();
		
		System.out.println("Connected");
		
		ResultSet rs = s.executeQuery("select * from job_status where job_id='JOB_ARC_BRM_JOURNAL_202305191451100' and status = 'CANCELLED'");
		
		while(rs.next()) {
			System.out.println("The Status is " +rs.getString("sub_stage")+" "+rs.getString("status"));
			System.out.println("The Source System is " + rs.getString("src_system"));
			driver = browserInitialization();
			System.out.println("Browser Initialized");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vignesh");
			driver.findElement(By.id("password")).sendKeys("vignesh");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//b[text()='Dashboard ']")).click();
			driver.findElement(By.linkText("BRM")).click();
			driver.findElement(By.name("jobId")).sendKeys(rs.getString("job_id"));
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			break;
		    
		}
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.toString());
		}
			
		

	}

}
