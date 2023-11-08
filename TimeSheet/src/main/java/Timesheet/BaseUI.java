package Timesheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.ExtentReportManager;
import Report.timestamputils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUI {

	public static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;

	
	public String launchBrowser(String browserName) {
		 
		try {
		        if(browserName.equalsIgnoreCase("chrome")) {
		        	  WebDriverManager.chromedriver().setup();
		        	  driver = new ChromeDriver();
		        	 reportPass("Browser launched successfully");
		        }
		        else if(browserName.equalsIgnoreCase("edge")) {
		        	WebDriverManager.edgedriver().setup();
		        	driver=new EdgeDriver();
		        	reportPass("Browser launched successfully");
		        	
		        }
		        else if(browserName.equalsIgnoreCase("Opera")) {
		        		WebDriverManager.operadriver().setup();
		        		driver=new OperaDriver();
		        		reportPass("Browser launched successfully");
		        }
		        else {
		              WebDriverManager.safaridriver().setup();
		              driver=new SafariDriver();
		             reportPass("Browser launched successfully");
		        }
		     }catch(Exception e) {
		    	 reportFail(e.getMessage());
		     }
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		    	if(prop==null) {
		    		prop=new Properties();
		    		try {
						prop.load(new FileInputStream("C:\\Users\\2269363\\eclipse-workspace\\TimeSheet\\src\\main\\resources\\properties\\Config.properties"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		
		    	}
			return browserName;
		}
	public void navigateToUrl(String urlkey) {
		
		try {
			driver.get(prop.getProperty(urlkey));
			reportPass("Navigated to targeted website successfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void visiblityOfElement(WebElement ele) {
		try {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void windowHandling() {
		try {
		String parent=driver.getWindowHandle();
	
		Set<String>windows=driver.getWindowHandles();
		Iterator<String>itr=windows.iterator();
		while(itr.hasNext()) {
			String child_window=itr.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				logger.log(Status.INFO,"Window focus is switched");

			}
		}
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
		}
	public void verifyTitle() {
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Be.Cognizant - Home")) {
			System.out.println("Title is validated"+title);
			reportPass("Title is validated - "+title);
		}
		else {
			reportFail("Title is mismatched");
		}
	}
	 public void shutdown() {
	    	driver.close();
	    }
	   public  void tearDown() {
	    	driver.quit();
	    	}

	
		  public void takeScreenShotOnFailure() {
			   TakesScreenshot src=(TakesScreenshot)driver;
			   File srcFile=src.getScreenshotAs(OutputType.FILE);
			   File dest=new File(System.getProperty("user.dir")+"/Screenshots/"+timestamputils.getDateStamp()+".png");
			   try {
				FileUtils.copyFile(srcFile, dest);
				logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/"+timestamputils.getDateStamp()+".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		   }

	
	 public void reportPass(String report) {
		   logger.log(Status.PASS, report);
	   }
	   public void reportFail(String report) {
		   logger.log(Status.FAIL, report);
		   takeScreenShotOnFailure();
	   }
}
