package hackthonproj_bookshelf;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utils.ExcelWrite;

public class BeingAtHome extends BaseUi {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[4]")
	WebElement brand;
	
	@FindBy(id="filters_brand_name_By_home")
	WebElement atHome;
	
	@FindBy(xpath="//div[contains(text(),'home')]/../../span")
	List<WebElement>nameList;
	
	@FindBy(xpath="//div[@class='price-number']//span")
	List<WebElement>priceList;
	
	public BeingAtHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectByBeingAtHome() {
		try {
		brand.click();
		Thread.sleep(5000);
		atHome.click();
		reportPass("Being @ home is selected");
	}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
		public void displayItems() {
			System.out.println("\nList of bookshelves under being @ home");
			try {
				if(nameList.size()!=0) {
			String[] bookShelves =new String[nameList.size()];
			String[] prices = new String[priceList.size()];
			for(int i=0;i<nameList.size();i++) {
				bookShelves[i]=nameList.get(i).getText();
				prices[i]=priceList.get(i).getText();
				System.out.println(i+1+","+ bookShelves[i]+"-"+prices[i]);
			}
			ExcelWrite.byAtHomeBookshelves(bookShelves , prices ,nameList.size() );
			reportPass("List of bookshelves under being @ home displayed successfully");
			}else {
				System.out.println("No such item");
				logger.log(Status.INFO, "No such item");
			}
				Thread.sleep(3000);
				}
			
			catch(Exception e) {
				reportFail(e.getMessage());
			}
		}
	

}
