package org.googlesearch.utils;

import java.io.IOException;
import java.util.Properties;

import static org.googlesearch.utils.DriverMaster.PROP_FILE;

public class PropertyLoader {
    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
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