package Database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver = new ChromeDriver();
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String FirstName = "";
	String LastName = "";
	String Email = "";
	String Password = "";
	
	@BeforeTest
	public void MySetup() throws SQLException{
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");
		driver.get("https://smartbuy-me.com/account/register"); 
	
	}
	
	@Test(priority = 1, enabled = false)
	public void InsertIntoDatabase () throws SQLException {
		String Query ="INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'New Corp', 'Smith', 'John', '123456789', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00);";
		stmt=con.createStatement();
		int RowEfected =stmt.executeUpdate(Query);
		System.out.println(RowEfected);
	}
	
	@Test(priority = 2, enabled = false)
	public void UpdateDatabase() throws SQLException {
		String Query ="UPDATE customers SET creditLimit = 75000 WHERE customerNumber = 999;";
		stmt=con.createStatement();
		int RowEfected =stmt.executeUpdate(Query);
		System.out.println(RowEfected);
		
	}
	@Test(priority = 3, enabled = false)
	public void Database() throws SQLException {
		String Query ="UPDATE customers SET creditLimit = 75000 WHERE customerNumber = 999;";
		stmt=con.createStatement();
		int RowEfected =stmt.executeUpdate(Query);
		System.out.println(RowEfected);
		
	}
	
	@Test(priority = 4)
	public void DeleteReadDatabaseAndRegister() throws SQLException {
	    String Query = "DELETE FROM customers WHERE customerNumber = 999;";
	    stmt = con.createStatement();
	    rs = stmt.executeQuery(Query);

	    while (rs.next()) {
	        FirstName = rs.getString("contactFirstName");  
	        System.out.println(FirstName);
	        
	        LastName = rs.getString("contactLastName");
	        System.out.println(LastName);
	        
	        Email = rs.getString("contactFirstName") +rs.getString("contactLastName")+ "@gmail.com";
	        System.out.println(Email);
	        
	        Password = rs.getString("phone");
	        System.out.println(Password);
	        
	        }            

	    driver.findElement(By.id("customer[first_name]")).sendKeys(FirstName);
	    driver.findElement(By.id("customer[last_name]")).sendKeys(LastName);
	    driver.findElement(By.id("customer[email]")).sendKeys(Email);
	    driver.findElement(By.id("customer[password]")).sendKeys(Password);
	    
	}

}
