package quickfuse.tests;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "TestDataProvider")
    static Object[][] getTestData() {
        List<HashMap> dataList = new ArrayList<>();
        dataList.add(addDataToMap("Test", "1234567890", "HelloWorld",
                "smtp.gmail.com", "25", "abc@gmail.com", "test@1234",
                "test@gmail.com", "abc@gmail.com", "SMS Not Sent", "xyz@gmail.com", "SMS Not Sent to number 1234567890"));
        Object[][] dataProviderObj = new HashMap[dataList.size()][1];
        int i=0;
        for(HashMap map : dataList) {
            dataProviderObj[i++][0] = map;
        }
        return dataProviderObj;
    }

    static HashMap<String,String> addDataToMap(String pageName, String phoneNumber, String smsContent,
                                               String smtpHost, String smtpPort, String username, String password,
                                               String to, String from, String subject, String cc, String emailContent) {
        HashMap<String,String> dataMap = new HashMap<>();
        dataMap.put("pageName", pageName);
        dataMap.put("phoneNumber", phoneNumber);
        dataMap.put("smsContent", smsContent);
        dataMap.put("smtpHost", smtpHost);
        dataMap.put("smtpPort", smtpPort);
        dataMap.put("username", username);
        dataMap.put("password", password);
        dataMap.put("to", to);
        dataMap.put("from", from);
        dataMap.put("subject", subject);
        dataMap.put("cc", cc);
        dataMap.put("emailContent", emailContent);
        return dataMap;
    }
}
