package utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    private static final Logger logger = Logger.getLogger(Property.class);

    public static String getProperty(String propertyKey) throws IOException {
        InputStream inputStream = null;
        String result = "";

        try {
            Properties prop = new Properties();
            String propFileName = "orange.properties";
            inputStream = Property.class.getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
            result = prop.getProperty(propertyKey);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return result;
    }
}
