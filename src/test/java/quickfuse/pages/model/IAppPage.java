package quickfuse.pages.model;

import quickfuse.pages.AppPage;

import java.util.HashMap;

public interface IAppPage {

    AppPage clickNewPage();
    AppPage enterPageName(HashMap<String,String> dataMap);
    AppPage clickCreate();
    AppPage clickMessaging();
    AppPage addSMSModule(String name, int destXOffset, int destYOffset);
    AppPage connectStartToSMS();
    AppPage enterPhoneNumber(HashMap<String,String> dataMap);
    AppPage enterSMSContent(HashMap<String,String> dataMap);
    AppPage addEmailModule(String name, int destXOffset, int destYOffset);
    AppPage enterSMTPHost(String host);
    AppPage enterSMTPPort(String port);
    AppPage enterUserName(String username);
    AppPage enterPassword(String password);
    AppPage enterFrom(String from);
    AppPage enterTo(String to);
    AppPage enterSubject(String subject);
    AppPage enterCC(String cc);
    AppPage enterEmailContent(String emailContent);
    AppPage fillEmailDetails(HashMap<String,String> dataMap);
    AppPage connectSMSNotSentToSendEmail();
    AppPage clickBasic();
    AppPage addExitModule(String name, int destXOffset, int destYOffset);

    AppPage connectEmailNotSentToExit();

    AppPage connectEmailSentToExit();

    AppPage connectSMSSentToExit();
}
