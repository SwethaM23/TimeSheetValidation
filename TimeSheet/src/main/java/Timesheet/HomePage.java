package Timesheet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class HomePage extends BaseUI {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"89c5ffca-2ffb-4052-a723-e99c8c9a14ef\"]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div/div/a")
	WebElement oneCognizant;
	
	@FindBy(xpath="//*[@id=\"closeBtn\"]")
	WebElement popup;
	
	@FindBy(xpath="//*[@id=\"oneC_searchAutoComplete\"]")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@id=\"newSearchQALST\"]/div[1]/div")
	WebElement timeSheetApp;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void scrollDown() {
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToOneC() {
		try {	
		oneCognizant.click();
		logger.log(Status.INFO, "Navigated successfully to One Cognizant portal");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void search() {
		try {
			searchBar.sendKeys("TimeSheet",Keys.ENTER);
			logger.log(Status.INFO, "Searched TimeSheet in searchbar ");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void timesheetapp() {
		try {
			new Actions(driver).moveToElement(timeSheetApp).click().perform();
			logger.log(Status.INFO, "Clicked Timesheet from search result");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
}
