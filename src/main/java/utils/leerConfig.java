package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class leerConfig {
    private static Properties properties;
        static {
            try {
                FileInputStream fi= new FileInputStream("src/test/resources/config.properties");
                properties=new Properties();
                properties.load(fi);

            } catch (IOException e){
                System.err.println("no se pudo leer el archivo config"+e.getMessage());
            }
    }
    public static String obtenerValor(String clave){
            return properties.getProperty(clave);
    }
    public static int obtenerTime(String clave){
        return Integer.parseInt(properties.getProperty(clave));
    }
}
