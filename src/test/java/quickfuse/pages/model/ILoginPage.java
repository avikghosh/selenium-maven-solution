package quickfuse.pages.model;

import quickfuse.pages.GetStartedPage;
import quickfuse.pages.LoginPage;

public interface ILoginPage {

    GetStartedPage clickCreate();
    LoginPage loadHomePage();
}
