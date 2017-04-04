package org.googlesearch.utils;

import org.googlesearch.main.GoogleTest;

import java.io.*;
import java.util.Properties;

import static org.googlesearch.utils.DriverMaster.PROP_FILE;

public class TestProperties {


    private final static Properties prop = new Properties();

    public static String getProperties(String key) {

        return prop.getProperty(key);
    }

    public static void readPropertiesFromFile() throws IOException {
        try (InputStream inputStream = GoogleTest.class.getClassLoader().getResourceAsStream(PROP_FILE)) {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                prop.load(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
