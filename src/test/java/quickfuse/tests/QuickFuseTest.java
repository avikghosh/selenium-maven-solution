package quickfuse.tests;
import org.testng.annotations.Test;
import quickfuse.pages.Pages;
import java.util.HashMap;


public class QuickFuseTest extends BaseTest {

    @Test(dataProvider = "getTestData", dataProviderClass = TestDataProvider.class)
    public void Check_User_Is_Able_To_Add_SMS_And_Email_Modules(HashMap<String,String> dataMap) {
        Pages
        .LoginPage()
        .loadHomePage()
        .clickCreate()
        .clickGetStarted()
        .clickNewPage()
        .enterPageName(dataMap)
        .clickCreate()
        .clickMessaging()
        .addSMSModule("Send An SMS", -150, 0)
        .enterPhoneNumber(dataMap)
        .enterSMSContent(dataMap)
        .connectStartToSMS()
        .addEmailModule("Send An Email", 250, -100 )
        .fillEmailDetails(dataMap)
        .connectSMSNotSentToSendEmail()
        .clickBasic()
        .addExitModule("SMS Sent Exit", -300, -100)
        .connectSMSSentToExit()
        .addExitModule("Email Sent Exit", 0, 200)
        .connectEmailSentToExit()
        .addExitModule("Email Not Sent Exit", 550, 200)
        .connectEmailNotSentToExit();
    }
}
