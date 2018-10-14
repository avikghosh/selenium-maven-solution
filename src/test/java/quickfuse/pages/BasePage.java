package quickfuse.pages;

import org.openqa.selenium.WebDriver;
import quickfuse.core.Wrapper;

public class BasePage {

    protected Wrapper wrapper;

    public BasePage(WebDriver driver) {
        this.wrapper = new Wrapper(driver);
    }


}
