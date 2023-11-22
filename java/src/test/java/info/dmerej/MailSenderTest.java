package info.dmerej;


import info.dmerej.mailprovider.SendMailRequest;
import org.junit.Assert;
import org.junit.Test;

public class MailSenderTest {
    @Test
    public void should_make_a_valid_http_request() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV1()
         User user = new User("karlos", "karols@gmail.com");
         String message = "message";
         SendMailRequest request = new SendMailRequest(user.email(),"New notification", message);
         MockHttpClient http = new MockHttpClient(request);

         //treatment
         new MailSender(http).sendV1(user, message);

         //test
        Assert.assertEquals(1, http.getSent());
    }

    @Test
    public void should_retry_when_getting_a_503_error() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV2()
        User user = new User("karlos", "karols@gmail.com");
        String message = "message";
        SendMailRequest request = new SendMailRequest(user.email(),"New notification", message);
        MockHttpClient http = new MockHttpClient(request);

        //treatment
        new MailSender(http).sendV2(user, message);

        //test
        Assert.assertEquals(2, http.getSent());
    }
}
