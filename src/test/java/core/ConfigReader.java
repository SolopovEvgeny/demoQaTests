package core;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Если вы хотите добавить поддержку браузерных возможностей
    public static DesiredCapabilities getBrowserCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browser = getProperty("browser");
        if ("chrome".equalsIgnoreCase(browser)) {
            capabilities.setBrowserName("chrome");
            capabilities.setVersion(getProperty("chrome.version"));
        }
        // Добавьте другие браузеры по мере необходимости
        return capabilities;
    }
}
