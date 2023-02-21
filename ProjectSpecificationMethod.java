package main.java.week7.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificationMethod {

	public RemoteWebDriver driver;
	public String excelFile;

	@Parameters({ "browser","url", "name", "password" })
	@BeforeMethod
	public void launchBrowser(String browser,String URL, String NAME, String PASSWORD) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=	new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		// ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(NAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

	}

@AfterMethod
public void tearDown() {
	
	driver.close();
}

@DataProvider(name="fetchData")
public String[][] getData() throws IOException {
	 String[][] readData = ReadEntireData.readData(excelFile);
	 return readData;
}
}
