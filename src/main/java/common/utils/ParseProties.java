package common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParseProties implements ParseFile {
    //private String default_path = "application.properties";
    private String default_path = "/home/trojan/workspace/sample/src/main/resources/application.properties";
    public ParseProties(){}
    public  ParseProties(String path){
        default_path = path;
    }
    @Override
    public String getValue(String  key) {
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(default_path);
            if (is != null) {
                properties.load(is);
                String value = properties.getProperty(key);
                return value;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
