package Akileshreddy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Akileshreddy.AbstractComponents.AbstractComponent;

public class Checkout extends AbstractComponent {

	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//*[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath ="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;

	@FindBy(css =".action__submit")
	WebElement submit;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions akki = new Actions(driver);
		akki.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public Confirmationpage submitOrder() {
		submit.click();
		return new Confirmationpage(driver);

	}

}
