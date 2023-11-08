package Timesheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utils.ExcelWrite;

public class UserDetails extends BaseUI {
	WebDriver driver;
	
	@FindBy(name="loginfmt")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")
	WebElement nextBtn;
	
	
	@FindBy(xpath="//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[2]/div/div/div[2]")
	WebElement call;
	
	@FindBy(xpath="//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[3]/a")
	WebElement notnow;
	
	@FindBy(xpath="//*[@id=\"O365_MainLink_MePhoto\"]/div/div/div/div/div[2]")
	WebElement profileLogo;
	
	@FindBy(xpath="//*[@id=\"mectrl_currentAccount_primary\"]")
	WebElement profileName;
	
	@FindBy(xpath="//*[@id=\"mectrl_currentAccount_secondary\"]")
	WebElement mailId;
	
	public UserDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void EnterUserDetails(String nameKey,String passKey) {
		email.sendKeys(prop.getProperty(nameKey));
		logger.log(Status.INFO, "Email Id is Entered Successfully");
		nextBtn.click();
		password.sendKeys(prop.getProperty(passKey));
		logger.log(Status.INFO, "Password is Entered Successfully");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextBtn.click();
		
	}
	public void calling() {
		try {
		call.click();
		reportPass("Authentication is successfull");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visiblityOfElement(notnow);
		
		visiblityOfElement(nextBtn);
	}
	public void profileDetails() {
		try {
		Thread.sleep(5000);
		profileLogo.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("User Details");
		System.out.println("Profile Name : "+profileName.getText());
		System.out.println("Email Id : "+mailId.getText());
		logger.log(Status.PASS, "User Name "+profileName.getText()+" Collected Successfully");
		logger.log(Status.PASS, "User Mail Id "+mailId.getText()+" Collected Successfully");
		ExcelWrite.userDetails(profileName.getText(),mailId.getText());
	
	}

}
