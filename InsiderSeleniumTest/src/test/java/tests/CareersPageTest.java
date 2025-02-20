package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class CareersPageTest extends BaseTest {

    @Test
    public void testCareerSectionsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.navigateToCareersPage();

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.areCareerSectionsDisplayed(), "Kariyer bölümleri görüntülenmiyor!");
    }

    @Test
    public void testApplyNowButton() {
        driver.get("https://www.example.com/careers");
        CareersPage careersPage = new CareersPage(driver);
        careersPage.clickApplyNow();
        Assert.assertTrue(driver.getCurrentUrl().contains("careers"), "URL 'careers' içermiyor!");
    }
}

