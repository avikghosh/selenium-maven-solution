package quickfuse.tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import quickfuse.core.ConfigReader;
import quickfuse.core.DriverManager;
import quickfuse.core.TestGlobals;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        ConfigReader.readConfigAndLoadToTestGlobals("src/test/resources/config.properties");
    }

    @BeforeMethod(alwaysRun = true)
    public void before(Method method) {
        System.out.println("Starting test method " + method.getName());
        TestGlobals.ssPath+= "/" + method.getName();
        TestGlobals.moduleCounter = 2;
        TestGlobals.ssStepCounter = 1;
        TestGlobals.clearModules();
        new File(Paths.get(TestGlobals.ssPath).toString()).mkdirs();
        System.out.println("Screenshot path set to " + TestGlobals.ssPath);
    }

    @AfterMethod(alwaysRun = true)
    public void after(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS) {
            System.out.println(result.getMethod().getMethodName() + " PASSED ");
        } else if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println(result.getMethod().getMethodName() + " FAILED");
        }
        tearDown();
    }
    private void tearDown() {
        System.out.println("Tearing down driver");
        if(DriverManager.getDriver()!= null) {
            DriverManager.tearDownDriver();
        } else {
            System.out.println("Driver Not Initialized, Nothing to quit");
        }
    }
}
