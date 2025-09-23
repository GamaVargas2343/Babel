package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshothelper {
    public static void capturaPantalla (WebDriver driver,String nombreBase){
        TakesScreenshot pantallazo = (TakesScreenshot) driver;
        File capturas = pantallazo.getScreenshotAs(OutputType.FILE);
        String tiempo = new SimpleDateFormat("dd-MM-yyyy_HHmmss").format(new Date());
        String nombreArchivo = "captura_"+ nombreBase + "_"+ tiempo + ".png";
        File destino = new File("evidencias/"+nombreArchivo);
        destino.getParentFile().mkdirs();
        try {
            Files.copy(capturas.toPath(),destino.toPath());
            System.out.println("la captura se guardo");
        } catch (IOException e){

            System.out.println("la captura no se guardo " + e.getMessage());

        }
    }
    public static String capturarPantallaDevolverRuta (WebDriver driver,String nombreBase){
        TakesScreenshot pantallazo = (TakesScreenshot) driver;
        File capturas = pantallazo.getScreenshotAs(OutputType.FILE);
        String tiempo = new SimpleDateFormat("dd-MM-yyyy_HHmmss").format(new Date());
        String nombreArchivo = "captura_"+ nombreBase + "_"+ tiempo + ".png";
        File destino = new File("evidencias/"+nombreArchivo);
        destino.getParentFile().mkdirs();
        try {
            Files.copy(capturas.toPath(),destino.toPath());
            System.out.println("la captura se guardo");
            return destino.getAbsolutePath();
        } catch (IOException e){

            System.out.println("la captura no se guardo " + e.getMessage());
            return null;

        }
    }
}
