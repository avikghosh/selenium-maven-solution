package quickfuse.core;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {


    public static void readConfigAndLoadToTestGlobals(String filePath) {

        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
            properties.load(file);
            loadPropertiesToTestGlobals(properties);
        } catch(Exception e) {
            System.out.println("Failure || Unable to load file " + filePath);
            AssertUtils.AssertFail();
        } finally {
            if(file!= null) {
                try {
                    file.close();
                } catch(Exception e) {
                    System.out.println("Unable to close file " + filePath);
                }
            }
        }
    }

    private static void loadPropertiesToTestGlobals(Properties properties) {
        TestGlobals.ssPath = properties.getProperty("ss.path");
        TestGlobals.chromedriverPath = properties.getProperty("chromedriver.path");

    }
}
