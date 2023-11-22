package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;
import lombok.Getter;



public class MockHttpClient implements  HttpClient{
    private final SendMailRequest excpectedRequest ;

    @Getter
    private int sent = 0;
    public MockHttpClient(SendMailRequest request){
        this.excpectedRequest = request;
    }
    public SendMailResponse post(String url, Object request){
        if (request instanceof SendMailRequest && excpectedRequest.equals(request)){
            sent++;
            return new SendMailResponse(503, "message");
        }
        return new SendMailResponse(503, "Error");
    }
}
