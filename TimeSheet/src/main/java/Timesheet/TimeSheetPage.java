package Timesheet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class TimeSheetPage extends BaseUI {
	
	WebDriver driver;
	String cur_week;
	String prev_week;
	String  pprev_week;
	
	
	@FindBy(xpath="//*[@id=\"win0divPTNUI_LAND_REC_GROUPLET$0\"]")
	WebElement timeSheetCard;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_PER_DESCR30$0\"]")
	WebElement week1;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_PER_DESCR30$1\"]")
	WebElement week2;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_PER_DESCR30$2\"]")
	WebElement week3;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_WRK_CTS_TS_SEARCH\"]")
	WebElement searchByDropDown;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS\"]")
	WebElement statusDropDown;
	
	@FindBy(xpath="//*[@id=\"CTS_TS_LAND_WRK_SEARCH\"]")
	WebElement searchBtn;
	
	@FindBy(xpath="//span[starts-with(@id,'CTS_TS_LAND_PER_CTS_TS_STATUS_LAND$')]")
	List<WebElement> stsVal;
	
	@FindBy(css="div[id ^='ptModTable']")
	WebElement alertDiv;
	
	@FindBy(xpath="//div[starts-with(@id ,'win0divCTS_TS_LAND_PER_$55$$')]")
	List<WebElement>statusDetails;
	

	
	@FindBy(xpath="//*[@id=\"#ICOK\"]")
	WebElement alert;
	
	public TimeSheetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicktimeSheetCard() {
		try {
			timeSheetCard.click();
			logger.log(Status.PASS, "TimeSheet Page is Selected");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void week1_details() {
		try {
			System.out.println("\nCurrent Week - "+week1.getText());
			logger.log(Status.INFO, "Current Week details Collected "+week1.getText());
			
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void week2_details() {
		try {
			System.out.println("Previous Week - "+week2.getText());
			logger.log(Status.INFO, "Previous Week details Collected "+week2.getText());
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void week3_details() {
		try {
			System.out.println("Before Previous Week - "+week3.getText());
			logger.log(Status.INFO, "Previous before Week details Collected "+week3.getText());
			
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void datefunction() {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(7);
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		c.set(c.getFirstDayOfWeek(),Calendar.SATURDAY);
        String start=df.format(c.getTime());
        for (int i = 0; i <6; i++) {
         c.add(c.getFirstDayOfWeek(), 1);
           }
        String end=df.format(c.getTime());
		
         cur_week=start+" To "+end;
        
        c.add(Calendar.DATE, -13);  
        String week2_start=df.format(c.getTime());
        for (int i = 0; i <6; i++) {
	         c.add(c.getFirstDayOfWeek(), 1);
	           }
	    String week2_end=df.format(c.getTime());
	    
         prev_week=week2_start+" To "+week2_end;
	     
        c.add(Calendar.DATE, -13); 
	    String week3_start=df.format(c.getTime());
	    for (int i = 0; i <6; i++) {
		      c.add(c.getFirstDayOfWeek(), 1);
		    }
		 String week3_end=df.format(c.getTime());
		 pprev_week=week3_start+" To "+week3_end;
	     
	
     }
      public void weekValidation() {
    	  if(cur_week.equalsIgnoreCase(week1.getText())) {
    		  System.out.println("\nSystem date and TimeSheet date both are similar for current week");
    		  reportPass("Current Week - System date and TimeSheet date are same");
    	  }
    	  if(cur_week.equalsIgnoreCase(week1.getText())) {
    		  System.out.println("System date and TimeSheet date both are similar for previous week");
    		  reportPass("Previous Week - System date and TimeSheet date are same");
    	  }
    	  if(cur_week.equalsIgnoreCase(week1.getText())) {
    		  System.out.println("System date and TimeSheet date both are similar for previous before previous week\n");
    		  reportPass("Previous Before Week - System date and TimeSheet date are same");
    	  }
    	  else {
    		  System.out.println("Doesn't match");
    		  reportFail("Doesn't match - System date and Timesheet date");
    	  }
      }
      public void searchBy() {
    	  try {
    	  Thread.sleep(4000);
  		 new Select(searchByDropDown).selectByVisibleText("Status");
  		 logger.log(Status.INFO, "DropDown Search By Status is selected");
  	}catch(Exception e) {
  		reportFail(e.getMessage());
  	}
      }
    public void selectByStatus(String val)  {
    	try {
    		Thread.sleep(4000);
    		new Select(statusDropDown).selectByVisibleText(val);
    		logger.log(Status.INFO, "DropDown Select by Status according "+val);
    		searchBtn.click();
    }catch(Exception e) {
    	reportFail(e.getMessage());
    }
    	
    	try{
    	Thread.sleep(5000);
    	
    	if(stsVal.size()>0) {
    	
    	int count=0;
    	for(WebElement ststxt:stsVal) {
    		if(ststxt.getText().equalsIgnoreCase(val)) {
    			count++;
    		}
    		
    	}
    	if(count>=1) {
    		System.out.println("Selected dropdown "+ val+" List ");
    		for(WebElement weekDetails:statusDetails) {
    			System.out.println(weekDetails.getText());
    		}
    		System.out.println("Selected dropdown value "+val+" matched in results");
    		logger.log(Status.PASS, "Contains All the "+val+" details");
    		}
    		System.out.println("-----------------------------------------------------");
    	}
    	if(alertDiv.isDisplayed())
		{
		alert.click();
		System.out.println("No results found for "+val);
	
		}
    	
    	}catch(Exception e) {
    		
    	}
   
    }
}

