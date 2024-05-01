import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillGenerationPage {
    private final WebDriver driver;

    public BillGenerationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void generateBill(String billId, String productId, String productName, String quantity) {
        driver.findElement(By.id("bill-id")).sendKeys(billId);
        driver.findElement(By.id("product-id")).sendKeys(productId);
        driver.findElement(By.id("productname")).sendKeys(productName);
        driver.findElement(By.id("quantity")).sendKeys(quantity);
        driver.findElement(By.id("add")).click();
    }

    public void navigateBackToHomePage() {
        driver.findElement(By.className("back-button")).click();
    }
}