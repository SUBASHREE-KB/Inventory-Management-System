import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateBackToHomePage() {
        driver.findElement(By.id("profileback")).click();
    }

    public void logout() {
        driver.findElement(By.className("text-white")).click();
    }
}