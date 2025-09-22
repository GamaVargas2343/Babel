import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginpage;
import utils.waithelper;

import java.time.Duration;


public class logintest {
    WebDriver driver;
    loginpage page;

    @BeforeMethod
    public void inicio(){

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/login");
        page=new loginpage(driver);


    }
    @Test
    public void testbueno(){
        page.iniciarSesion("tomsmith","SuperSecretPassword!");
        String mensaje = page.validacionlogin();
        Assert.assertTrue(mensaje.contains( "You logged into"),"el mensaje esperado no es exitoso");
    }
    @Test
    public void testmalo(){
        page.iniciarSesion("tomsmith1","SuperSecretPassword!1");
        String mensaje = page.validacionlogin();
        Assert.assertTrue(mensaje.contains( "Your username is invalid!"));
    }

    @AfterMethod
    public void Cerrar(){
        driver.quit();
    }

}
