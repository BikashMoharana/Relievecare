package Libraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
    /**
     * generic methodes for webdriver method
     * @author hp
     *
     */
     public class webdriverUtility {
	/**
	 * maximise methode
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * minimise methode
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	/**
	 * methods for implicity wait for page loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * methods for explicitlywait
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOf(WebDriver driver,WebElement element) 
	{
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitFortextToBePresentInElement(WebDriver driver,WebElement element,String text) 
	{
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.textToBePresentInElement(element,text));
	}
	
	
	/**
	 * method for dropdown handling by selecting index.
	 * @param driver
	 * @param drop
	 * @param index
	 */
	public void dropdownSelectByIndex(WebElement drop,int index) 
	{
		Select s=new Select(drop);
		s.selectByIndex(index);
	}
	
	
	/**
	 * method for dropdown handling by selecting visible text
	 * @param drop
	 * @param vtext
	 */
	public void dropdownSelectByVisibleText(WebElement drop,String vtext) 
	{
		Select s=new Select(drop);
		s.selectByVisibleText(vtext);;
	}
	/**
	 * method for dropdown handling by selecting value
	 * @param drop
	 * @param value
	 */
	public void dropdownSelectByValue(WebElement drop,String value) 
	{
		Select s=new Select(drop);
		s.selectByVisibleText(value);;
	}
	
	/**
	 * method for dropdown handling by Deselecting
	 * @param drop
	 * @param value
	 */
	public void dropdownDeselectByValue(WebElement drop,String value) 
	{
		Select s=new Select(drop);
		s.deselectByValue(value);
	}
	
	public void dropdownDeselectByVisibleText(WebElement drop,String vstext) 
	{
		Select s=new Select(drop);
		s.deselectByVisibleText(vstext);
	}
	
	public void dropdownDeselectByIndex(WebElement drop,int indexx) 
	{
		Select s=new Select(drop);
		s.deselectByIndex(indexx);
	}
	public void dropdownDeselectByAll(WebElement drop) 
	{
		Select s=new Select(drop);
		s.deselectAll();
	}
	/**
	 * Methods for dropdown for Options
	 * @param drop
	 */
	public void dropdownAllOptions(WebElement drop) 
	{
		Select s=new Select(drop);
		s.getOptions();
	}
	public void dropdownAllselectedOptions(WebElement drop) 
	{
		Select s=new Select(drop);
		s.getAllSelectedOptions();
	}
	public void dropdownFirstselectedOptions(WebElement drop) 
	{
		Select s=new Select(drop);
		s.getFirstSelectedOption();
	}
	
	
	
	
	
	
	/**
	 * Methods for Mouse action handling 
	 * @param driver
	 * @param element
	 */
	public void mouseToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();	
	}
	
	public void mouseRightClick(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	public void mouseClickandHold(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.clickAndHold().perform();
	}
	public void mouseDoubleClick(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public void mouseDragandDrop(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}
	public void mouseDragandDrop(WebDriver driver,WebElement element,int x,int y) 
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, x, y).perform();
	}
	public void mouseRelease(WebDriver driver,WebElement element,int x,int y) 
	{
		Actions act=new Actions(driver);
		act.release().perform();
	}
	
	
	
	
	
	/**
	 * methods for scroll by amount
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void elementamountscroll(WebDriver driver,int x,int y) 
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x,y);
	}
	/**
	 * methods for scroll to element
	 * @param driver
	 * @param element
	 */
	public void elementtoscroll(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element);
	}
	/**
	 * methods for scroll handling for scrollfromorigin
	 * @param driver
	 * @param scrori
	 * @param x
	 * @param y
	 * @param element
	 */
	public void elementOriginScrollby(WebDriver driver,ScrollOrigin scrori,int x,int y,WebElement element) 
	{
		Actions act=new Actions(driver);
		ScrollOrigin sc=ScrollOrigin.fromElement(element);
		act.scrollFromOrigin(sc, x, y);
	}
	
	
	
	
	
	
	/**
	 * methods for alert popup
	 * @param driver
	 */
	public void pageAlertOk(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	public void pageAllertDismiss(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public String pageAllertGetData(WebDriver driver) 
	{
		return driver.switchTo().alert().getText();
	}
	
	public void pageAllertSendData(WebDriver driver,String value) 
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	
	
	
	
	
	
	/**
	 * Methods for frame handling
	 * @param driver
	 * @param index
	 */
	public void pagetoIndexframe(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	
	public void pagetoIdframe(WebDriver driver,String idvalue) 
	{
		driver.switchTo().frame(idvalue);
	}
	
	public void pagetoElementframe(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	public void parentframe(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	
	
	public void moveToMainPage(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	
	
	
	
	/**
	 * This methode will scroll down 500 unit
	 * @param driver
	 */
	public void Scrolldown(WebDriver driver) 
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeAsyncScript("Window.scrollBy(0,500);", " ");	
	}
	/**
	 * This methode will scroll up 500 unit
	 * @param driver
	 */
	public void ScrollUp(WebDriver driver) 
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeAsyncScript("Window.scrollBy(0,-500);", " ");	
	}
	
	/**
	 * Methoode for screen shot
	 * @param driver
	 * @param screenshootname
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenshootname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		File f1=new File(".\\screenshoot\\"+screenshootname+".png");
		FileHandler.copy(f, f1);
		return f1.getAbsolutePath();
	}
	/**
	 * Method for window handling
	 * @param driver
	 * @param title
	 */
	public void switchToWindow(WebDriver driver,String title)
	{
		Set<String> allwin=driver.getWindowHandles();
		for(String winID:allwin)
		{
			String wintitle=driver.switchTo().window(winID).getTitle();
			if(wintitle.contains(title)) 
			{
				break;
			}
		}
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
