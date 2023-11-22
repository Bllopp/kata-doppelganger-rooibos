package info.dmerej;


import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MailSenderTest {
    @Test
    public void should_make_a_valid_http_request() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV1()
         User user = new User("karlos", "karols@gmail.com");
         String message = "message";
         SendMailRequest request = new SendMailRequest(user.email(),"New notification", message);
         HttpClient http = Mockito.mock(HttpClient.class);
         Mockito.when(http.post(Mockito.anyString(), Mockito.any())).thenReturn(new SendMailResponse(200, "response"));

         //treatment
         new MailSender(http).sendV1(user, message);

         //test
        Mockito.verify(http).post("https://api.mailprovider.com/v3/", request);
    }

    @Test
    public void should_retry_when_getting_a_503_error() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV2()
        User user = new User("karlos", "karols@gmail.com");
        String message = "message";
        SendMailRequest request = new SendMailRequest(user.email(),"New notification", message);
        HttpClient http = Mockito.mock(HttpClient.class);

        Mockito.when(http.post(Mockito.anyString(), Mockito.any())).thenReturn(new SendMailResponse(503, "response"));


        //treatment
        new MailSender(http).sendV2(user, message);

        //test
        Mockito.verify(http, Mockito.times(2)).post("https://api.mailprovider.com/v3/",request);
    }
}
