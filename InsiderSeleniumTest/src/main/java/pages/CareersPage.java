package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[normalize-space(.)='Our Locations']")
    private WebElement locationsBlock;

    @FindBy(xpath = "//a[normalize-space()='See all teams']")
    private WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h2[contains(.,'Life at Insider')]")
    private WebElement lifeAtInsiderBlock;

    public boolean areCareerSectionsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(locationsBlock));
        wait.until(ExpectedConditions.visibilityOf(seeAllTeamsButton));
        wait.until(ExpectedConditions.visibilityOf(lifeAtInsiderBlock));
        return locationsBlock.isDisplayed() &&
                seeAllTeamsButton.isDisplayed() &&
                lifeAtInsiderBlock.isDisplayed();
    }

    public void clickSeeAllTeams() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAllTeamsButton));
        clickElement(seeAllTeamsButton);
    }
}
