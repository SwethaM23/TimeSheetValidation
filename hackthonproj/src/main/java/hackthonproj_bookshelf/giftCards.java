package hackthonproj_bookshelf;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class giftCards extends BaseUi {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement giftCardlink;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	WebElement birth_day;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[2]")
	WebElement amount;
	

	public giftCards(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void navigateTogift() {
		try {
		giftCardlink.click();
		reportPass("Navigated to Gift cards page successfully!");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		}
	public void giftSelection() {
		try {
		Actions action=new Actions(driver);
		action.click(birth_day).perform();
		reportPass("Birthday/Anniversary selected successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void amountSele() {
		try {
		amount.click();
		reportPass("Amount rs.5000 is selected");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	public void scrollUp() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", giftCardlink); 
	}
	public void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}

}
