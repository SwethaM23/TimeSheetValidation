package hackthonproj_bookshelf;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetails extends BaseUi {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	WebElement nextBtn;
	
	
	@FindBy(name="recipient_name")
	WebElement recipient_name;
	
	@FindBy(name="recipient_email")
	WebElement recipient_email;
	
	@FindBy(name="recipient_mobile_number")
	WebElement r_mobile_number;
	
	@FindBy(name="customer_name")
	WebElement customer_name;
	
	@FindBy(name="customer_email")
	WebElement customer_email;
	
	@FindBy(name="customer_mobile_number")
	WebElement c_mobile_number;
	
	@FindBy(name="customer_address")
	WebElement c_address;
	
	@FindBy(name="zip")
	WebElement zip;
	
	@FindBy(name="message")
	WebElement msg;
	
	@FindBy(xpath="//fieldset[@class='_1ASZD']//input[@class='tDZNG _15qWO']")
	List<WebElement> error;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	public UserDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void nextclick() {
		nextBtn.click();
		
	}
	
	public void filldetails(String data[] ) {
		try {
		recipient_name.sendKeys(data[0]);
		recipient_email.sendKeys(data[1]);
		r_mobile_number.sendKeys(data[2]);
		customer_name.sendKeys(data[3]);
		customer_email.sendKeys(data[4]);
		c_mobile_number.sendKeys(data[5]);
		c_address.sendKeys(data[6]);
		zip.sendKeys(data[7]);
		msg.sendKeys(data[8]);
		//reportPass("All the details successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}

		try {
			
			Thread.sleep(5000);
			 submitBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void warnmessage() {
			
			try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			for(Object ele:error) 
			{
					String message = (String)js.executeScript("return arguments[0].validationMessage;", ele);
					if(message!="") {						
							System.out.println("\nError Message:"+message);
							reportFail(message);
	
						}
			}
			}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	    
		}
}
	
	



