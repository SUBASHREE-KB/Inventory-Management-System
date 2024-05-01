import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class NewTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private SupplierPage supplierPage;
    private BillGenerationPage billGenerationPage;
    private ProfilePage profilePage;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        supplierPage = new SupplierPage(driver);
        billGenerationPage = new BillGenerationPage(driver);
        profilePage = new ProfilePage(driver);

        driver.get("http://localhost:8080/index");
        driver.findElement(By.id("loginbutton")).click();
        // Login only once before executing any test method
        loginPage.login("pavi@gmail.com","123");
        
    }

    @Test(description = "Functionality test", priority = 0)
    public void testFunctionality() throws InterruptedException {
        homePage.navigateToProductPage();
        productPage.addProduct("210", "10", "500", "10-05-2024", "156");
        productPage.editProductQuantity("20");
        productPage.deleteProduct();
        productPage.navigateBackToHomePage();
        homePage.navigateToSupplierPage();
        supplierPage.addSupplier("Yuvaraj", "156", "12b.mithra@gmail.com", "7604981442", "No. 1A SP avenue tamilnadu chennai");
        supplierPage.editSupplierAddress("122,chennai");
        supplierPage.deleteSupplier();
        supplierPage.navigateBackToHomePage();
        homePage.navigateToBillGenerationPage();
        billGenerationPage.generateBill("21", "210", "cheese", "1");
        billGenerationPage.navigateBackToHomePage();
        homePage.navigateToProfilePage();
        profilePage.navigateBackToHomePage();
        profilePage.logout();
    }

    @AfterMethod
    public void closingTheApp() throws Exception {
        
        driver.quit();
    }
}