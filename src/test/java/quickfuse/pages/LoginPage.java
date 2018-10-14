package quickfuse.pages;

import org.openqa.selenium.WebDriver;
import quickfuse.pages.model.ILoginPage;

public class LoginPage extends BasePage implements ILoginPage {

    private String createAnAppXpath = "//*[@id='link-create']";
    private String homePageURL = "http://www.quickfuseapps.com";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public GetStartedPage clickCreate() {
        wrapper.clickElement(createAnAppXpath);
        return Pages.GetStartedPage();
    }

    public LoginPage loadHomePage() {
        wrapper.loadPage(homePageURL);
        return this;
    }
}
