
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginpage {


    WebDriver driver;


    //Selectores
    private By username =By.id("username");
    private By password =By.id("password");
    private By login = By.cssSelector("#login > button > i");


    //Constructor

    public loginpage(WebDriver driver){
        this.driver=driver;
    }

    //Acciones

    public void iniciarSesion(String nombreusuario,String contrasena)
    {

        driver.findElement(username).sendKeys(nombreusuario);
        driver.findElement(password).sendKeys(contrasena);
        driver.findElement(login).click();




    }

}
