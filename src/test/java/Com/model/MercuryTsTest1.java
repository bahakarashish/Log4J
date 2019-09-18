package Com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTsTest1  
{


public WebDriver driver;
static Logger logger =Logger.getLogger(MercuryTsTest1.class);
@Test(priority=1,description="Verify that invalid user able to login into Mercury Tours application by using invalid username and password")	 
public void loginwithValidds() 
{
	System.out.println("Github changes");
PropertyConfigurator.configure("G:\\New Selenium Workspace-9-08-2019\\Log4jTestngDemo\\src\\test\\resource\\log4j.properties");		  
//Verify title of web page
String act_title1=driver.getTitle();		  
String exp_title1="Welcome: Mercury Tours";
logger.info("Title of welcome page is: "+act_title1);
//Verify current url of web page
String act_url=driver.getCurrentUrl();
String exp_url="http://www.newtours.demoaut.com/mercurywelcome.php";
AssertJUnit.assertEquals(act_url, exp_url);
 logger.info("Current web page url is:"+act_url);
driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
driver.findElement(By.xpath("//input[@name='login']")).click();
logger.info("User has login into Mercury Tours Application successfully");
//Verify Flight Finder image display
boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
boolean exp_flag1=true;
AssertJUnit.assertEquals(act_flag1, exp_flag1);
logger.debug("Flight finder image is displayed: "+act_flag1);
driver.findElement(By.linkText("SIGN-OFF")).click();
}
@Test(priority=2,description="Verify sign on page")	  
public void verifySignOnPage()
{
//Verify Sign on page title		  
String act_title2=driver.getTitle();
String exp_title2="Sign-on Mercury Tours";
logger.error("Sign on page title is: "+act_title2);
 AssertJUnit.assertEquals(act_title2, exp_title2, "Wrong title");
logger.error("Sign on page title is: "+act_title2);
}
@Test(priority=3,description="Verify that invalid user not able to login into Mercury tours application by using invalid username and password")	  
public void loginwithInvalidds()  
{	  
driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");  
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
driver.findElement(By.xpath("//input[@name='login']")).click();
//Verify Sign on image display
boolean act_flag3=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
boolean exp_flag3=true;
AssertJUnit.assertEquals(act_flag3, exp_flag3);
logger.warn("Sign on image is displayed: "+act_flag3);
}
@BeforeMethod
public void getAllCookies() 
{
Set<Cookie> cookies=driver.manage().getCookies();		  
for(Cookie cookie:cookies)
{
logger.info(cookie.getName());		 
 }
} 
@AfterMethod	  
public void captureScreenshot() throws IOException 
{
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		  
FileUtils.copyFileToDirectory(src, new File("G:\\New Selenium Workspace-9-08-2019\\Log4jTestngDemo\\Screenshot\\"));
logger.info("Screenshot has captured successfully");	 
 }
@BeforeClass  
public void maximizeBrowser() 
{
driver.manage().window().maximize();		  
logger.info("Chrome browser is maximized succesfully");
}
@AfterClass	  
public void deleteAllCookies()
{
driver.manage().deleteAllCookies();		  
logger.info("deleteAllCookies method under AfterClass" );
}
@BeforeTest	  
public void enterApplicationURL() 
{
driver.get("http://www.newtours.demoaut.com/mercurywelcome.php");	      
logger.info("Application URL is entered successfully");	  
}
@AfterTest
public void dbConnectionClosed() 	  
{
logger.info("dbConnectionClosed method under AfterTest"); 
 }
@BeforeSuite
public void openBrowser()	  
{
System.setProperty("webdriver.chrome.driver","E:\\selenium 29-06-2019\\chromedriver.exe");
driver= new ChromeDriver();
logger.info("Chrome browser is opened successfully");	  
}
 @AfterSuite
public void closeBrowser() 	  
{
driver.close();	  
logger.info("Chrome browser is closed successfully");
}
}
