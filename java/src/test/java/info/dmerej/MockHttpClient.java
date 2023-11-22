package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;
import lombok.Getter;

public class MockHttpClient implements  HttpClient{
    private final SendMailRequest excpectedRequest ;

    @Getter
    private boolean sent = false;
    public MockHttpClient(SendMailRequest request){
        this.excpectedRequest = request;
    }
    public SendMailResponse post(String url, Object request){
        if (excpectedRequest.equals(request)){
            sent = true;
            return new SendMailResponse(200, "message");
        }
        return new SendMailResponse(503, "Error");
    }
}
