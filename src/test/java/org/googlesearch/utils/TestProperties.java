package org.googlesearch.utils;

import java.io.IOException;
import java.util.Properties;


public class TestProperties {

    private static final String PROP_FILE = "/testdata.properties";

    public static String getProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(TestProperties.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}