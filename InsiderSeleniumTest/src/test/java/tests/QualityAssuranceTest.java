package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityAssurancePage;

public class QualityAssuranceTest extends BaseTest {

    @Test
    public void testQAJobFilteringAndViewRole() throws InterruptedException {
        driver.get("https://useinsider.com/careers/quality-assurance/");

        QualityAssurancePage qaPage = new QualityAssurancePage(driver);

        qaPage.clickSeeAllQAJobs();

        qaPage.filterJobs("Istanbul, Turkiye", "Quality Assurance");

        int jobCount = qaPage.getJobCount();
        Assert.assertTrue(jobCount > 0, "Filtre uygulandıktan sonra QA iş ilanı bulunamadı!");

        Assert.assertTrue(qaPage.verifyJobListings("Quality Assurance", "Quality Assurance", "Istanbul, Turkey"),
                "Bazı iş ilanları yanlış kategori veya lokasyona ait!");

        qaPage.clickViewRole();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("lever"),
                "Yönlendirme Lever başvuru sayfasına gerçekleşmedi!");
    }
}
