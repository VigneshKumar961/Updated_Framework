package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.base;

public class DB_Pointing_SIT_BRM extends base {

	
	@Test
	public void pointing_brm()
	{
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.78.194.83:1521/APIMDB","AP_BRM_ARC","brmarc123");
		System.out.println(con.toString());
		Statement s = con.createStatement();
		
		System.out.println("Connected");
		
		ResultSet rs = s.executeQuery("SELECT\r\n"
				+ "            regexp_substr(host, '\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}') ip_address,\r\n"
				+ "            CASE regexp_substr(host, '\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}')\r\n"
				+ "                WHEN '10.78.193.6'     THEN\r\n"
				+ "                    'ST - E2'\r\n"
				+ "                WHEN '10.78.194.196'   THEN\r\n"
				+ "                    'ST - E8'\r\n"
				+ "                WHEN '10.78.196.92'    THEN\r\n"
				+ "                    'SIT - SUP02'\r\n"
				+ "                WHEN '10.78.193.196'   THEN\r\n"
				+ "                    'SIT - E4'\r\n"
				+ "                WHEN '10.78.195.68'    THEN\r\n"
				+ "                    'SIT - E7'\r\n"
				+ "                ELSE\r\n"
				+ "                    host\r\n"
				+ "            END \"ENVIRONMENT\"\r\n"
				+ "        FROM\r\n"
				+ "            all_db_links\r\n"
				+ "        WHERE\r\n"
				+ "            db_link = 'BRMDB'");
		
		
		
		while(rs.next()) {
			
			System.out.println("The BRMDB Pointing is in: " + rs.getString("IP_ADDRESS") + " and Env is: " + rs.getString("ENVIRONMENT") );
					    
		}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	    
	}
}
