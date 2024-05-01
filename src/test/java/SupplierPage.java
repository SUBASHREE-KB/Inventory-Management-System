import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupplierPage {
    private final WebDriver driver;

    public SupplierPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addSupplier(String name, String id, String email, String phone, String address) {
        driver.findElement(By.id("suppliername")).sendKeys(name);
        driver.findElement(By.id("supid")).sendKeys(id);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.id("supplier")).click();
    }

    public void editSupplierAddress(String newAddress) {
        driver.findElement(By.className("edit-button")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys(newAddress);
        driver.findElement(By.className("button")).click();
    }

    public void deleteSupplier() {
        driver.findElement(By.className("delete-button")).click();
    }

    public void navigateBackToHomePage() {
        driver.findElement(By.id("supplierback")).click();
    }
}