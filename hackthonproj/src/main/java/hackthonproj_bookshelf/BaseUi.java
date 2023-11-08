package hackthonproj_bookshelf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.ExtentReportManager;
import Report.timestamputils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUi {
	public static WebDriver driver;
	
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	 public static ExtentTest logger;
	 Properties prop;

	 
	 public void setup(String browserName) {
	        // Set up the WebDriverManager for chrome driver
	        // Create the driver object
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
	     
	     }catch(Exception e) {
	    	 reportFail(e.getMessage());
	     }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        if(prop==null) {
	        	prop=new Properties();
	        	try {
					prop.load(new FileInputStream("C:\\Users\\2269363\\eclipse-workspace\\hackthonproj\\src\\main\\resources\\properties\\config.properties"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	      
		
	}
	 public void navigateToUrl(String urlkey) {
			try {
		    	driver.get(prop.getProperty(urlkey));
		    	System.out.println("Navigated to :"+driver.getTitle());
		    	reportPass("Navigated to targeted website successfully");
		    }
			catch(Exception e) {
				reportFail(e.getMessage());
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
		  
		    public void verifyTitle(String title_key) {
		    	try {
		    	String title=driver.getTitle();
		    	
		    	
		    	logger.log(Status.INFO, "Original title:"+title);
		    	logger.log(Status.INFO, "Excepted title:"+prop.getProperty(title_key));
		    	if(prop.getProperty(title_key).equals(title)){
		    		logger.log(Status.PASS, "Title verified successfully!");
		    	
		    	}
		    	else {
		    		logger.log(Status.ERROR,"Title mismatched");
		    	}
		    
		    }
		    	catch(Exception e) {
		    	reportFail(e.getMessage());
		    }
		    }
		    /******************reportfunction***********************/
		   public void reportPass(String report) {
			   logger.log(Status.PASS, report);
		   }
		   public void reportFail(String report) {
			   logger.log(Status.FAIL, report);
			   takeScreenShotOnFailure();
		   }
		  
}
