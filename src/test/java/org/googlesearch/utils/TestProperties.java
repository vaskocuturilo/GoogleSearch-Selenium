package org.googlesearch.utils;

import org.googlesearch.main.GoogleTest;

import java.io.*;
import java.util.Properties;

public class TestProperties {

    protected final static Properties prop = new Properties();
    private static String PROP_FILE = "testdata.properties";

    public static String getProperties(String key) {

        return prop.getProperty(key);
    }

    public static void readPropertiesFromFile() throws IOException {
        InputStream inputStream = GoogleTest.class.getClassLoader().getResourceAsStream(PROP_FILE);
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
