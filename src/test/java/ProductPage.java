import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productId, String quantity, String price, String expiryDate, String supplierId) {
         Connection con;
         String productname=null;
         int id= Integer.parseInt(productId);
         driver.findElement(By.name("prodid")).sendKeys(productId);
         try {
            String url = "jdbc:mysql://localhost:3306/db_fin";
            String dbUsername = "root";
            String dbPassword = "root";
            con = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            // Fetch user credentials from database
            String query = "SELECT prodname FROM product WHERE prodid =? "; 
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                productname = rs.getString("prodname");
            }
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("prodname")).sendKeys(productname);
        driver.findElement(By.name("prodqty")).sendKeys(quantity);
        driver.findElement(By.name("prodprice")).sendKeys(price);
        driver.findElement(By.name("prodexp")).sendKeys(expiryDate);
        driver.findElement(By.name("supid")).sendKeys(supplierId);
        driver.findElement(By.id("productadd")).click();
        
    }

    public void editProductQuantity(String newQuantity) {
        driver.findElement(By.className("edit-button")).click();
        driver.findElement(By.id("prodqty")).clear();
        driver.findElement(By.id("prodqty")).sendKeys(newQuantity);
        driver.findElement(By.className("button")).click();
    }

    public void deleteProduct() {
        driver.findElement(By.className("delete-button")).click();
    }

    public void navigateBackToHomePage() {
        driver.findElement(By.id("backbutton")).click();
    }
}
