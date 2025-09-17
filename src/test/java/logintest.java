import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Driver;


public class logintest {

    public static void main (String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.cssSelector("#login > button > i"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();
        driver.quit();

        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://the-internet.herokuapp.com/login");
        WebElement username1 = driver1.findElement(By.id("username"));
        WebElement password1 = driver1.findElement(By.id("password"));
        WebElement login1 = driver1.findElement(By.cssSelector("#login > button > i"));

        username1.sendKeys("tomsmith1");
        password1.sendKeys("SuperSecretPassword!");
        login1.click();
        driver.quit();

    }
}
