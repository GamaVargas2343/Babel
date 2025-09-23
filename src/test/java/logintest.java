import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.loginpage;
import utils.waithelper;
import utils.screenshothelper;
import java.time.Duration;
import utils.leerConfig;

public class logintest {
    WebDriver driver;
    loginpage page;

    @BeforeMethod
    public void inicio(){

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(leerConfig.obtenerTime("timeout")));
        driver.get(leerConfig.obtenerValor("Url"));
        page=new loginpage(driver);


    }
    @DataProvider (name = "Datos" )
    public Object [][] obtenerDatos (){

        return new Object[][]{
                {
                        leerConfig.obtenerValor("usuarioCorrecto") ,leerConfig.obtenerValor("passwordCorrecto") , "You logged into"

                },
                {
                        leerConfig.obtenerValor("usuarioIncorrecto") ,leerConfig.obtenerValor("passwordIncorrecto"), "Your username is invalid!"
                }

        };

    }
    @Test (dataProvider = "Datos")
    public void testLogin(String nombreUsuario,String contrasena , String mensajeEsperado){
        page.iniciarSesion(nombreUsuario,contrasena);
        String mensajeObtenido = page.validacionlogin();
        Assert.assertTrue(mensajeObtenido.contains(mensajeEsperado),"el mensaje esperado no es exitoso");
    }


    @AfterMethod
    public void Cerrar(ITestResult resultado){
        if (ITestResult.FAILURE== resultado.getStatus())
          screenshothelper.capturaPantalla(driver,resultado.getName());
        driver.quit();

    }

}
