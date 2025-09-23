package utils;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class reporteHelper {
   private static ExtentReports extent;
   private static ExtentTest test;

   public static ExtentReports configReporte (){
       if(extent==null){
           String tiempo = new SimpleDateFormat("dd-MM-yyyy_HHmmss").format(new Date());
           ExtentSparkReporter reporter=new ExtentSparkReporter("reportes/reporte_"+tiempo+".html");
           extent=new ExtentReports();
           extent.attachReporter(reporter);
       }
       return extent;
   }
   public static ExtentTest crearTest(String nombreTest){
       test=configReporte().createTest(nombreTest);
       return test;
   }
   public static void generarReporte(){
       if (extent!=null){
           extent.flush();
       }
   }
}
