package utils;

import lombok.AllArgsConstructor;

public class Constants {

    @AllArgsConstructor
    public enum WebDriverProperties {
        CHROME_DRIVER("webdriver.chrome.driver"),
        FIREFOX_DRIVER("webdriver.gecko.driver"),
        EDGE_DRIVER("webdriver.edge.driver");

        public final String value;
    }
}
