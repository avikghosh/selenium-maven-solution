package quickfuse.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Wrapper {

    private WebDriver driver;
    private WebDriverWait wait;
    private int WAIT_TIMEOUT = 10;
    private int DRAG_WAIT_TIME = 1;

    public Wrapper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, WAIT_TIMEOUT);
    }

    public WebElement findElement(String xpath) {
        WebElement element = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element = driver.findElement(By.xpath(xpath));
            System.out.println("Success || Element Find || Xpath: " + xpath);
        } catch (Exception e) {
            System.out.println("Failure || Element Find || Xpath: " + xpath + " " + e.getMessage());
        }
        return element;
    }

    public void clickElement(String xpath) {
        WebElement element = findElement(xpath);
        if (element!= null) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                System.out.println("Success || Element Click || Xpath: " + xpath);
                takeScreenshot();
            } catch (Exception e) {
                System.out.println("Failure || Element Click || Xpath: " + xpath + " " + e.getMessage());
                takeScreenshot();
                AssertUtils.AssertFail();
            }
        } else {
            System.out.println("Failure || Element Click || Cannot find Element with Xpath: " + xpath);
            takeScreenshot();
            AssertUtils.AssertFail();
        }
    }

    public void enterText(String xpath, String text) {
        WebElement element = findElement(xpath);
        int counter = 0;
        try {
            do {
                element.clear();
                element.click();
                element.sendKeys(text);
            } while(counter++ < 3 && !element.getAttribute("value").equals(text));
            if(!element.getAttribute("value").equals(text)) {
                System.out.println("Failure || Enter Text || Xpath: " + xpath + " || Text: " + text);
                takeScreenshot();
                AssertUtils.AssertFail();
            }
            System.out.println("Success || Enter Text || Xpath: " + xpath + " || Text: " + text);
            takeScreenshot();
        } catch(Exception e) {
            System.out.println("Failure || Enter Text || Xpath: " + xpath + " || Text: " + text + " " + e.getMessage());
            takeScreenshot();
            AssertUtils.AssertFail();
        }
    }

    public boolean isElementDisplayed(String xpath) {
        boolean isDisplayed = false;
        try {
            WebElement element = findElement(xpath);
            if (element != null) {
                isDisplayed = element.isDisplayed();
            }
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
    public void takeScreenshot() {
        File srcFile = null;
        try {
            if(driver != null) {
                srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                if(srcFile != null)
                    FileUtils.copyFile(srcFile, new File(TestGlobals.ssPath + "/" + TestGlobals.ssStepCounter++ + ".png"));
            }
        } catch (Exception e) {
            System.out.println("Failure || Take Screenshot ||  with Exception " + e.getMessage());
        }
    }
    public void loadPage(String url) {
        try {
            driver.get(url);
            System.out.println("Success || Load Page || URL:" + url);
            takeScreenshot();
        } catch(Exception e) {
            System.out.println("Failure || Load Page || URL:" + url + " with Exception " + e.getMessage());
            takeScreenshot();
            AssertUtils.AssertFail();

        }
    }

    public void dragElementToElement(String sourceXpath, String destinationXpath) {

        WebElement sourceElement = findElement(sourceXpath);
        WebElement destinationElement = findElement(destinationXpath);
        if(sourceElement != null && destinationElement != null) {
            try {
                new Actions(driver).moveToElement(sourceElement).pause(Duration.ofSeconds(DRAG_WAIT_TIME)).clickAndHold(sourceElement).pause(Duration.ofSeconds(DRAG_WAIT_TIME))
                        .moveByOffset(1, 0).moveToElement(destinationElement).moveByOffset(1, 0).pause(Duration.ofSeconds(DRAG_WAIT_TIME)).release().perform();
                System.out.println("Success || Drag Element To Element  || Source: " + sourceXpath + " Destination: " + destinationXpath);
                takeScreenshot();
            } catch (Exception e) {
                System.out.println("Failure || Drag Element To Element  || Source: " + sourceXpath + " Destination: " + destinationXpath + " with Exception "+ e.getMessage());
                AssertUtils.AssertFail();
                takeScreenshot();
            }
        } else {
            System.out.println("Failure || Drag Element To Element  || Elements not found || Source: " + sourceXpath + " Destination: " + destinationXpath);
            takeScreenshot();
            AssertUtils.AssertFail();
        }

    }

    public void dragElementToElement(String sourceXpath, String destinationXpath, int destXOffset, int destYOffset) {

        WebElement sourceElement = findElement(sourceXpath);
        WebElement destinationElement = findElement(destinationXpath);
        if(sourceElement != null && destinationElement != null) {
            try {
                new Actions(driver).moveToElement(sourceElement).pause(Duration.ofSeconds(DRAG_WAIT_TIME)).clickAndHold(sourceElement).pause(Duration.ofSeconds(DRAG_WAIT_TIME))
                        .moveByOffset(1, 0).moveToElement(destinationElement).moveByOffset(destXOffset, destYOffset).pause(Duration.ofSeconds(DRAG_WAIT_TIME)).release().perform();
                System.out.println("Success || Drag Element To Element  || Source: " + sourceXpath + " Destination: " + destinationXpath);
                takeScreenshot();
            } catch (Exception e) {
                System.out.println("Failure || Drag Element To Element  || Source: " + sourceXpath + " Destination: " + destinationXpath + " with Exception "+ e.getMessage());
                AssertUtils.AssertFail();
                takeScreenshot();
            }
        } else {
            System.out.println("Failure || Drag Element To Element  || Elements not found || Source: " + sourceXpath + " Destination: " + destinationXpath);
            AssertUtils.AssertFail();
            takeScreenshot();
        }

    }
}