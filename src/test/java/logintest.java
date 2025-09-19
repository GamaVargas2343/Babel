import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.loginpage;


public class logintest {
    WebDriver driver;
    loginpage page;

    @BeforeMethod
    public void inicio(){

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        page=new loginpage(driver);


    }
    @Test
    public void testbueno(){
        page.iniciarSesion("tomsmith","SuperSecretPassword!");
    }
    @Test
    public void testmalo(){
        page.iniciarSesion("tomsmith1","SuperSecretPassword!1");
    }

    @AfterMethod
    public void Cerrar(){
        driver.quit();
    }

}
