import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class logintest {
    WebDriver driver;
    @BeforeMethod
    public void inicio(){

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

    }
    @Test
    public void testbueno(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.cssSelector("#login > button > i"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();
    }
    @Test
    public void testmalo(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.cssSelector("#login > button > i"));

        username.sendKeys("tomsmith1");
        password.sendKeys("SuperSecretPassword!1");
        login.click();
    }

    @AfterMethod
    public void Cerrar(){
        driver.quit();
    }

}
