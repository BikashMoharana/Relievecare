package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Libraries.excelfileUtility;
import Libraries.javaUtility;
import Libraries.propertyfileutility;
import Libraries.webdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public webdriverUtility ww=new webdriverUtility();
	public excelfileUtility ee=new excelfileUtility();
	public javaUtility jj=new javaUtility();
	public propertyfileutility pp=new propertyfileutility();
	
	@BeforeSuite
	public void config() {
		System.out.println("----Data Base Connected----");
		
	}
	
	@BeforeClass
	public void launchbrowser() throws IOException 
	{
		String BROWSER=pp.readdatafrompropertiesfile("browser");
		String UR=pp.readdatafrompropertiesfile("url");
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} 
		else if (BROWSER.equalsIgnoreCase("Firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} 
		else if (BROWSER.equalsIgnoreCase("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} 
		else 
		{
			System.out.println("Invalid Browser Name");
		}
		ww.maximizeWindow(driver);
		ww.waitForPageLoad(driver);
		//PUT URL
		driver.get(UR);
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		String USERNAM=pp.readdatafrompropertiesfile("username");
		String PASSWOR=pp.readdatafrompropertiesfile("password");
		loginpage l=new loginpage(driver);
		l.loginToApp(USERNAM, PASSWOR);
	}
	
	@AfterMethod
	public void logout()
	{
		//SIGNOUT
		homepage h=new homepage(driver);
				h.Signout(driver);
	}
	
	@AfterClass
	public void closeBrowser() 
	{
		driver.close();
	}
	
	@AfterSuite
	public void closeServer() 
	{
		System.out.println("----Date Base Conection Close----");
	}
}
