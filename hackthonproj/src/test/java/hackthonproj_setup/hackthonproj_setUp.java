package hackthonproj_setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import Report.ExtentReportManager;
import hackthonproj_bookshelf.BaseUi;
import hackthonproj_bookshelf.BeingAtHome;
import hackthonproj_bookshelf.UserDetails;
import hackthonproj_bookshelf.bookshelf;
import hackthonproj_bookshelf.giftCards;
import utils.ExcelWrite;
import utils.dataprovider;

public class hackthonproj_setUp extends BaseUi{
	
	bookshelf book;
	giftCards gift;
	UserDetails user;
	BeingAtHome home;
	
	ExtentReports report=ExtentReportManager.getReportInstance();
	
	
	@BeforeTest()
	public void lauch() throws InterruptedException {
		
		logger=report.createTest("Browser launch test");
		setup("chrome");
		navigateToUrl("url_key");
		verifyTitle("title_key");
				
	}
	@Test(priority=1)
	public void boofshelves() throws InterruptedException {
		logger=report.createTest("Book shelf under 15000 ") ;
		book=new bookshelf(driver);
		book.navbarLink();
	
		book.alertHandle();
		Thread.sleep(5000);
		book.inStock();
		Thread.sleep(5000);
		book.priceSelection();
		Thread.sleep(5000);
		book.listOfElements();
		Thread.sleep(5000);
	
		
	}
	@Test(priority=2)
	public void beingAtHome() {
		logger=report.createTest("Being @ Home validation");
		home=new BeingAtHome(driver);
		home.selectByBeingAtHome();
		home.displayItems();
	}
	@Test(priority=3)
	public void giftcards() throws InterruptedException {
	
		gift=new giftCards(driver);
		logger=report.createTest("Gift card selection validation");
		gift.scrollUp();
		gift.navigateTogift();
		Thread.sleep(5000);
		gift.scrollDown();
		gift.giftSelection();
		Thread.sleep(5000);
		gift.amountSele();
		
	}
	@Test(priority=4,dataProvider="userdetails",dataProviderClass=dataprovider.class)
	public void details(String data[]) throws InterruptedException {
		user=new UserDetails(driver);
		logger=report.createTest("User details validation");
		user.nextclick();
		Thread.sleep(5000);
		user.filldetails(data);
		user.warnmessage();
	}
	

	
	@AfterTest
	public void addReport() {
		
		report.flush();
		driver.close();
		
	}
}
