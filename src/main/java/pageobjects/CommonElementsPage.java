package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElementsPage {

	WebDriver driver;

	public CommonElementsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[normalize-space()='Desktop Notifications']")
	WebElement DesktopNotification;
	@FindBy(xpath = "//a[normalize-space()='About']")
	private WebElement aboutLink;
	@FindBy(xpath = "//a[@id='candidate-login-before']")
	private WebElement careerLogo;
	@FindBy(xpath = "//h1[normalize-space()='Flipkart Help Center | 24x7 Customer Care Support']")
	private WebElement contactHeader;

	@FindBy(xpath = "//img[@class='W5mR4e']")
	WebElement groceryPageImage;
	@FindBy(xpath = "//button[normalize-space()='Start Selling']")
	private WebElement startSellingButton;
	@FindBy(xpath = "//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//a[@class='ast-custom-button-link']")
	private WebElement menuItem;
	@FindBy(xpath = "//strong[contains(text(),'Lending Partners of Scapic Innovations Private Lim')]")
	private WebElement termsHeader;
	@FindBy(xpath = "//a[@aria-label='Go Home']")
    private WebElement shopsyElement;
	@FindBy(xpath = "//div[@class='NmD+EK']")
	private WebElement travelpage;
	
	@FindBy(xpath = "//h1[normalize-space()='Gift Card Store']")
	private WebElement giftcard;
	
	@FindBy(xpath = "//h1[normalize-space()='Fashion']")
	private WebElement fashion;
	
	

	public WebElement DesktopNotification() {
		return DesktopNotification;
	}
	
	public WebElement fashion() {
		return fashion;
	}
	
	public WebElement giftcard() {
		return giftcard;
	}

	public WebElement aboutLink() {
		return aboutLink;
	}

	public WebElement careerLogo() {
		return careerLogo;
	}

	public WebElement contactHeader() {
		return contactHeader;
	}

	public WebElement groceryPageImage() {
		return groceryPageImage;
	}

	public WebElement startSellingButton() {
		return startSellingButton;
	}

	public WebElement menuItem() {
		return menuItem;
	}

	public WebElement termsHeader() {
		return termsHeader;
	}

	public WebElement shopsyElement() {
		return shopsyElement;
	}

	public WebElement travelpage() {
		return travelpage;
	}

}
