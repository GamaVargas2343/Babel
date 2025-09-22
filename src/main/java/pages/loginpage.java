
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.waithelper;


public class loginpage {


    WebDriver driver;
    waithelper wait;

    //Selectores
    private By username =By.id("username");
    private By password =By.id("password");
    private By login = By.cssSelector("#login > button > i");
    private By flash = By.id("flash");

    //Constructor

    public loginpage(WebDriver driver){
        this.driver=driver;
        this.wait= new waithelper(driver);
    }

    //Acciones

    public void iniciarSesion(String nombreusuario,String contrasena)
    {

        driver.findElement(username).sendKeys(nombreusuario);
        driver.findElement(password).sendKeys(contrasena);
        driver.findElement(login).click();




    }
    public String validacionlogin() {

        return wait.esperarElementoVisible(flash).getText();



    }
}
