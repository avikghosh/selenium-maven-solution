package quickfuse.pages;

import org.openqa.selenium.WebDriver;
import quickfuse.pages.model.IGetStartedPage;

public class GetStartedPage extends BasePage implements IGetStartedPage {
    public GetStartedPage(WebDriver driver) {
        super(driver);
    }

    String letsGetStartedXpath = "//*[@id='intro-dialog-cont']/div[2]/button";

    public AppPage clickGetStarted() {
        wrapper.clickElement(letsGetStartedXpath);
        return Pages.AppPage();
    }
}
