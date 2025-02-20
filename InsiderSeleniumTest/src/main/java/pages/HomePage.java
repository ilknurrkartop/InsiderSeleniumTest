package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("https://useinsider.com/");
    }

    @FindBy(xpath = "//nav//a[normalize-space()='Company']")
    private WebElement companyMenu;

    @FindBy(xpath = "//nav//a[normalize-space()='Careers']")
    private WebElement careersLink;

    public void navigateToCareersPage() {
        clickElement(companyMenu);
        clickElement(careersLink);
    }
}
