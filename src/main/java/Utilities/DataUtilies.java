package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Properties;

public class DataUtilies {
    private final static String test_data="src/test/resources/test-data/";
    public static String GetDataJson(String FileName,String key) throws FileNotFoundException {
        try {
            FileReader reader=new FileReader(test_data+FileName+".json");
            JsonElement elment= JsonParser.parseReader(reader);
            return elment.getAsJsonObject().get(key).getAsString();
        }
     catch (Exception e){
            e.printStackTrace();
            return "";
     }



    }
public static String GetDataFromEnvironment(String FileName,String key) throws IOException {
    Properties properties=new Properties();
    properties.load(new FileInputStream(test_data+FileName+".properties"));
    return properties.getProperty(key);
}
}
