package quickfuse.pages;

import org.openqa.selenium.support.PageFactory;
import quickfuse.core.DriverManager;

public class Pages {

    public static LoginPage LoginPage() {
        return PageFactory.initElements(DriverManager.getDriver(), LoginPage.class);
    }

    public static GetStartedPage GetStartedPage() {
        return PageFactory.initElements(DriverManager.getDriver(), GetStartedPage.class);
    }

    public static AppPage AppPage() {
        return PageFactory.initElements(DriverManager.getDriver(), AppPage.class);
    }
}
