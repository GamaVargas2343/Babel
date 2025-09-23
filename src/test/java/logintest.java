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

import java.lang.reflect.Method;
import java.time.Duration;
import utils.leerConfig;
import com.aventstack.extentreports.*;
import utils.reporteHelper;


public class logintest {
    WebDriver driver;
    loginpage page;
    ExtentTest test;

    @BeforeMethod
    public void inicio(Method metodo) {

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(leerConfig.obtenerTime("timeout")));
        driver.get(leerConfig.obtenerValor("Url"));
        page=new loginpage(driver);
        test=reporteHelper.crearTest(metodo.getName());

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
        try {
            page.iniciarSesion(nombreUsuario, contrasena);
            String mensajeObtenido = page.validacionlogin();
            Assert.assertTrue(mensajeObtenido.contains(mensajeEsperado), "el mensaje esperado no es exitoso");
            test.pass("Test paso correctamente");
        }catch (Exception e) {
            test.fail("el test ha fallado"+e.getMessage());
            throw e;
        }
    }


    @AfterMethod
    public void Cerrar(ITestResult resultado){
        if (ITestResult.FAILURE== resultado.getStatus())
          screenshothelper.capturaPantalla(driver,resultado.getName());
        driver.quit();

    }
    @AfterSuite
    public void cerrarReporte(){
        reporteHelper.generarReporte();
    }


}
