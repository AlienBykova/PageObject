package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {

    private static Properties properties = new Properties();

    @SneakyThrows
    public static String getProperty(String propertyName) {
        properties.load(new FileInputStream("src/main/resources/webdriver.properties"));
        return properties.getProperty(propertyName);
    }
}
