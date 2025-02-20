package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class QualityAssurancePage extends BasePage {

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    private WebElement seeAllQAJobsButton;

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement selectedLocation;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    private WebElement locationDropdown;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement locationSearchBox;

    @FindBy(xpath = "//span[@class='select2-selection__clear']")
    private WebElement clearSelection;

    @FindBy(id = "filter-by-department")
    private WebElement departmentDropdown;

    @FindBy(xpath = "//div[contains(@class, 'position-list-item')]")
    private List<WebElement> jobListings;

    @FindBy(xpath = "//div[contains(@class, 'position-title')]")
    private List<WebElement> jobTitles;

    @FindBy(xpath = "//span[contains(@class, 'position-department')]")
    private List<WebElement> jobDepartments;

    @FindBy(xpath = "//div[contains(@class, 'position-location')]")
    private List<WebElement> jobLocations;

    @FindBy(xpath = "//a[contains(@href, '/careers/position/') and contains(text(), 'View Role')]")
    private WebElement viewRoleButton;

    public void clickSeeAllQAJobs() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAllQAJobsButton));
        clickElement(seeAllQAJobsButton);
    }

    public void selectLocation(String location) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));

        if (clearSelection.isDisplayed()) {
            clickElement(clearSelection);
        }

        locationDropdown.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(locationSearchBox));
        locationSearchBox.sendKeys(location);
        Thread.sleep(1000);
        locationSearchBox.sendKeys(Keys.ENTER);
    }

    public void filterJobs(String location, String department) throws InterruptedException {
        selectLocation(location);
        wait.until(ExpectedConditions.elementToBeClickable(departmentDropdown));
        new org.openqa.selenium.support.ui.Select(departmentDropdown).selectByVisibleText(department);
    }

    public int getJobCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(jobListings));
        return jobListings.size();
    }

    public boolean verifyJobListings(String expectedPosition, String expectedDepartment, String expectedLocation) {
        for (int i = 0; i < jobListings.size(); i++) {
            String title = jobTitles.get(i).getText();
            String department = jobDepartments.get(i).getText();
            String location = jobLocations.get(i).getText();

            if (!title.contains(expectedPosition) || !department.contains(expectedDepartment) || !location.contains(expectedLocation)) {
                System.out.println("❌ Hatalı iş ilanı bulundu: " + title + " - " + department + " - " + location);
                return false;
            }
        }
        return true;
    }

    public void clickViewRole() {
        wait.until(ExpectedConditions.elementToBeClickable(viewRoleButton));
        clickElement(viewRoleButton);
    }
}
