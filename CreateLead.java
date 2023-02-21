package main.java.week7.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.week6.day2.ProjectSpecificationMethod;


	public class CreateLead extends ProjectSpecificationMethod {
		@BeforeTest
		public void setup() {
			String excelFile = "CreateLead";
		}
		
	     @Test(dataProvider="fetchData")
		public void runcreate(String cname,String fname,String lname) {

			/*ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys("DemoCSR");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();*/
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			driver.findElement(By.name("submitButton")).click();
			//driver.close();
		}
	     
	    /* @DataProvider(name="CreateLead")
	     public String[][] getData() throws IOException {
	    	 String[][] readData = ReadEntireData.readData("CreateLead");
	    	 return readData;*/
	    	   	 
	     }
	


