package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        Assert.assertTrue(driver.getTitle().contains("Insider"), "Ana sayfa başlığı Insider içermiyor!");

        homePage.navigateToCareersPage();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("careers"), "URL 'careers' içermiyor!");
    }

    @Test
    public void testExampleButton() {
        driver.get("https://www.example.com");
        HomePage homePage = new HomePage(driver);
        homePage.clickExampleButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("example"), "URL 'example' içermiyor!");
    }
}
