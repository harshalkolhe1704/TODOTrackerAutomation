package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getBrowser() {

        Properties prop = new Properties();

        try {
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            prop.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop.getProperty("browser");
    }
}
