package TimeSheetSetup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Timesheet.BaseUI;
import Timesheet.HomePage;
import Timesheet.TimeSheetPage;
import Timesheet.UserDetails;

public class TimeSheetSetUp  extends BaseUI{
	

	UserDetails user;
	HomePage home;
	TimeSheetPage time;
	String browser;
	
	@BeforeTest
	public void launch() {
		logger=report.createTest("Launching Browser");
		 browser=launchBrowser("chrome");
	}
	@Test(priority=1)
	public void navigationToWebsite() {
		logger=report.createTest("Navigated to URL");
		navigateToUrl("website_key");
	}
	@Test(priority=2)
	public void details() throws InterruptedException {
		logger=report.createTest("User Details");
		user=new UserDetails(driver);
		Thread.sleep(5000);
		if(browser!="Edge") {
		user.EnterUserDetails("email_id","pass");
		}
		user.calling();
		user.profileDetails();
	}
	@Test(priority=3)
	public void OneC() throws InterruptedException {
		home=new HomePage(driver);
		logger=report.createTest("Navigated to OneC portal");
		verifyTitle();
		home.scrollDown();
		home.navigateToOneC();
		
	}
	@Test(priority=4)
	public void timeSheetNavigation() throws InterruptedException {
		logger=report.createTest("Search for TimeSheet");
		home.windowHandling();
		home.search();
		Thread.sleep(5000);
		home.timesheetapp();
	
	}
	@Test(priority=5)
	public void  timesheet() throws InterruptedException {
		time=new TimeSheetPage(driver);
		Thread.sleep(5000);
		time.windowHandling();
		time.clicktimeSheetCard();
		Thread.sleep(5000);
		logger=report.createTest("TimeSheet - Week Details & Validations");
		time.week1_details();
		time.week2_details();
		time.week3_details();
		time.datefunction();
		time.weekValidation();
		
	
	}
	@Test(priority=6)
	public void searchDropDown() {
		
		time.searchBy();
	}
	@Test(priority=7)
	public void Status_Approved() {
		time.selectByStatus("Approved");
	}
	@Test(priority=8)
	public void Status_Pending() {
		time.selectByStatus("Pending");
	}
	@Test(priority=9)
	public void Status_Overdue() {
		time.selectByStatus("Overdue");
	}
	@Test(priority=10)
	public void Status_PartialApprove() {
		time.selectByStatus("Partially Approved");
	}
	@Test(priority=11)
	public void Status_Saved() {
		time.selectByStatus("Saved");
	}
	@Test(priority=12)
	public void Status_Revision() {
		time.selectByStatus("Sent Back for Revision");
	}
	@Test(priority=13)
	public void Status_submitForApprove() {
		time.selectByStatus("Submitted for Approval");
	}
	
	@AfterTest
	public void finish() {
		report.flush();
		tearDown();
	}
}
