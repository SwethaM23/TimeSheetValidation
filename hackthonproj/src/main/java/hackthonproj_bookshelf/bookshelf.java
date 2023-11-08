package hackthonproj_bookshelf;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelWrite;

public class bookshelf  extends BaseUi{
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/span")
	WebElement navLiving_Xpath;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[3]/ul/li[2]/a")
	WebElement navBookShelf_Xpath;
	
	@FindBy(xpath="//*[@id=\"filters_availability_In_Stock_Only\"]")
	WebElement excludeOutOfStock;
	
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[2]")
	WebElement storageType;
	
	@FindBy(xpath="//*[@id=\"filters_storage_type_Open\"]")
	WebElement openType;
	
	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div[1]/div/div[2]/a[1]")
	WebElement alerthandle;
	
	
	@FindBy(xpath="//li[@data-group='price']")
	WebElement pricedropdown;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")
	WebElement priceRange;
	
	@FindBy(xpath="//span[@itemprop=\"name\" and @class=\"name\"]")
	List<WebElement>namelist;
	
	@FindBy(xpath="//div[@class='price-number']//span")
	List<WebElement>pricelist;
	
	
	public bookshelf(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navbarLink() {
		try {
		navLiving_Xpath.click();
		}
		catch(Exception e){
			reportFail(e.getMessage());
		}
		try {
		navBookShelf_Xpath.click();
		reportPass("Selected to targeted Bookshelves submenu successfully");
		 }
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void alertHandle() {
		try{
			alerthandle.click();
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void inStock() {
		try {
		excludeOutOfStock.click();
		
		storageType.click();
		
		openType.click();
		Thread.sleep(5000);
		reportPass("Open & Exclude out of stock is selected successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void priceSelection()  {
		try {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pricedropdown)).click();
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		try {
		Actions actions = new Actions(driver);
		actions.moveToElement(priceRange).click().dragAndDropBy(priceRange, -245, 0).perform();
		reportPass("Amount below 15000 selected successfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		  }
	
	public void listOfElements() {
		System.out.println("3 Bookshelves below Rs. 15000, with Storage type as open & exclude out of stock\n");
		try {
			String[] bookShelves =new String[3];
			String[] prices = new String[3];
		for(int i=0;i<3;i++) {
			bookShelves[i]=namelist.get(i).getText();
			prices[i]=pricelist.get(i).getText();
			System.out.println(i+1 +","+	bookShelves[i]+"-"+prices[i]);
		}
		ExcelWrite.below15000BookShelves(bookShelves , prices , 3);
		reportPass("Bookshelves below Rs. 15000, displayed successfully");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	}

