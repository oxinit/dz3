package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// using properties through java.util
public class PropertiesReader {

    Properties properties =new Properties();

    public PropertiesReader(){
        FileInputStream fis;
        try{
            fis= new FileInputStream("src/main/resources/prop.properties");
            properties.load(fis);
            fis.close();
        }catch(IOException e){
            System.err.println("ERROR: Properties file don`t exist");
        }
    }

    public String getUrl(){
        String URL =properties.getProperty("URL");
        return URL;
    }
    public String getDriverName(){
        String driverName =properties.getProperty("DRIVER_NAME");
        return driverName;
    }
}

