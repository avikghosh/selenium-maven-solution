package quickfuse.pages;

import org.openqa.selenium.WebDriver;
import quickfuse.core.TestGlobals;
import quickfuse.pages.model.IAppPage;

import java.util.HashMap;

public class AppPage extends BasePage implements IAppPage {


    public AppPage(WebDriver driver) {
        super(driver);
    }

    private String newPageXpath = "//a[@id='add-page']";
    private String pageNameXpath = "//*[@id='create-dialog']//input[@name='name']";
    private String createXpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[text()='Create' and contains(@class, 'ui-corner-all ui-button')]";
    private String menuMessagingXpath = "//a[contains(text(), 'Messaging')]";
    private String menuBasicXpath = "//a[contains(text(), 'Basic')]";
    private String menuSendSMSXpath = "//*[@id='accordion']//li[text()='Send an SMS']";
    private String menuSendEmailXpath = "//*[@id='accordion']//li[text()='Send an Email']";
    private String menuExitXpath = "//*[@id='accordion']//li[text()='Hang Up or Exit']";
    private String canvasXpath = "//*[@id='tabs-2']";
    private String startConnectorXpath = "//div[@id='tabs-2']//div[@id='module-1']//div[contains(@class, 'mod-south')]/div[contains(@class, 'syn-node')]";
    private String notSentConnectorXpath = "//div[@id='module-%s']//div[contains(@class,'syn-node-attached-e')]";
    private String sentConnectorXpath = "//div[@id='module-%s']//div[contains(@class,'syn-node-attached-w')]";
    private String topConnectorXpath = "//div[@id='module-%s']//div[contains(@class,'syn-receptor-north')]";
    private String phoneNumberXpath = "//*[@id='module-%s']//textarea[contains(@class, 'phone')]";
    private String smtpHostXpath = "//input[@name='smtp_url']";
    private String smtpPortXpath = "//input[@name='port']";
    private String smtpUserNameXpath = "//input[@name='username']";
    private String smtpPasswordXpath = "//input[@name='password']";
    private String emailFromXpath = "//textarea[@name='from_constant']";
    private String emailToXpath = "//textarea[@name='to_constant']";
    private String emailSubjectXpath = "//textarea[@name='subject_constant']";
    private String emailCCXpath = "//textarea[@name='cc_constant']";
    private String contentsXpath =   "//*[@id='module-%s']//textarea[contains(@name, 'message_phrase') and contains(@class, 'autogrow')]";
    private String exitXpath = "//*[@id='module-%s']//div[contains(@class, 'syn-receptor-north')]";

    public AppPage clickNewPage() {
        wrapper.clickElement(newPageXpath);
        return this;
    }

    public AppPage enterPageName(HashMap<String,String> dataMap) {
        wrapper.enterText(pageNameXpath, dataMap.get("pageName"));
        return this;
    }

    public AppPage clickCreate() {
        wrapper.clickElement(createXpath);
        return this;
    }

    public AppPage clickMessaging() {
        wrapper.clickElement(menuMessagingXpath);
        return this;
    }

    public AppPage addSMSModule(String name, int destXOffset, int destYOffset) {
        wrapper.dragElementToElement(menuSendSMSXpath, canvasXpath, destXOffset, destYOffset);
        TestGlobals.addToModules(name);
        return this;
    }

    public AppPage connectStartToSMS() {
        wrapper.dragElementToElement(startConnectorXpath, String.format(topConnectorXpath, TestGlobals.getModuleId("Send An SMS")));
        return this;
    }

    public AppPage enterPhoneNumber(HashMap<String,String> dataMap) {
        wrapper.enterText(String.format(phoneNumberXpath, TestGlobals.getModuleId("Send An SMS")), dataMap.get("phoneNumber"));
        return this;
    }

    public AppPage enterSMSContent(HashMap<String,String> dataMap) {
        wrapper.enterText(String.format(contentsXpath, TestGlobals.getModuleId("Send An SMS")), dataMap.get("smsContent"));
        return this;
    }

    
    public AppPage addEmailModule(String name, int destXOffset, int destYOffset) {
        wrapper.dragElementToElement(menuSendEmailXpath, canvasXpath, destXOffset, destYOffset);
        TestGlobals.addToModules(name);
        return this;
    }

    public AppPage enterSMTPHost(String host) {
        wrapper.enterText(smtpHostXpath, host);
        return this;
    }

    public AppPage enterSMTPPort(String port) {
        wrapper.enterText(smtpPortXpath, port);
        return this;
    }

    public AppPage enterUserName(String username) {
        wrapper.enterText(smtpUserNameXpath, username);
        return this;
    }

    public AppPage enterPassword(String password) {
        wrapper.enterText(smtpPasswordXpath, password);
        return this;
    }

    public AppPage enterFrom(String from) {
        wrapper.enterText(emailFromXpath, from);
        return this;
    }

    public AppPage enterTo(String to) {
        wrapper.enterText(emailToXpath, to);
        return this;
    }

    public AppPage enterSubject(String subject) {
        wrapper.enterText(emailSubjectXpath, subject);
        return this;
    }

    public AppPage enterCC(String cc) {
        wrapper.enterText(emailCCXpath, cc);
        return this;
    }

    public AppPage enterEmailContent(String emailContent) {
        wrapper.enterText(String.format(contentsXpath, TestGlobals.getModuleId("Send An Email")), emailContent);
        return this;
    }

    public AppPage fillEmailDetails(HashMap<String,String> dataMap) {
        enterSMTPHost(dataMap.get("smtpHost"));
        enterSMTPPort(dataMap.get("smtpPort"));
        enterUserName(dataMap.get("username"));
        enterPassword(dataMap.get("password"));
        enterFrom(dataMap.get("from"));
        enterTo(dataMap.get("to"));
        enterSubject(dataMap.get("subject"));
        enterCC(dataMap.get("cc"));
        enterEmailContent(dataMap.get("emailContent"));
        return this;
    }

    public AppPage connectSMSNotSentToSendEmail() {
        wrapper.dragElementToElement(String.format(notSentConnectorXpath, TestGlobals.getModuleId("Send An SMS")),
                String.format(topConnectorXpath, TestGlobals.getModuleId("Send An Email")));
        return this;
    }

    public AppPage clickBasic() {
        wrapper.clickElement(menuBasicXpath);
        return this;
    }

    public AppPage addExitModule(String name, int destXOffset, int destYOffset) {
        wrapper.dragElementToElement(menuExitXpath, canvasXpath, destXOffset, destYOffset);
        TestGlobals.addToModules(name);
        return this;
    }

    public AppPage connectEmailNotSentToExit() {
        wrapper.dragElementToElement(String.format(notSentConnectorXpath, TestGlobals.getModuleId("Send An Email")),
                String.format(exitXpath, TestGlobals.getModuleId("Email Not Sent Exit")));
        return this;
    }

    public AppPage connectEmailSentToExit() {
        wrapper.dragElementToElement(String.format(sentConnectorXpath,TestGlobals.getModuleId("Send An Email")) ,
                String.format(exitXpath, TestGlobals.getModuleId("Email Sent Exit")));
        return this;
    }

    public AppPage connectSMSSentToExit() {
        wrapper.dragElementToElement(String.format(sentConnectorXpath,TestGlobals.getModuleId("Send An SMS")),
                String.format(exitXpath, TestGlobals.getModuleId("SMS Sent Exit")));
        return this;
    }
}
