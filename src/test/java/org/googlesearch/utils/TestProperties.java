package org.googlesearch.utils;

import java.io.*;
import java.util.Properties;

public class TestProperties {


    protected final static Properties prop = new Properties();

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }

    public static void readPropertiesFromFile() throws IOException {
        InputStream inputStream = DriverMaster.class.getClassLoader().getResourceAsStream("testdata.properties");
        try {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                prop.load(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } finally {
            inputStream.close();
        }
    }
}
