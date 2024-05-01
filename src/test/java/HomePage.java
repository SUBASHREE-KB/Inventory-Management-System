import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToProductPage() {
        driver.findElement(By.id("product")).click();
    }

    public void navigateToSupplierPage() {
        driver.findElement(By.id("supplier")).click();
    }

    public void navigateToBillGenerationPage() {
        driver.findElement(By.id("bill")).click();
    }

    public void navigateToProfilePage() {
        driver.findElement(By.xpath("/html/body/nav/div[3]/a[1]")).click();
    }
}