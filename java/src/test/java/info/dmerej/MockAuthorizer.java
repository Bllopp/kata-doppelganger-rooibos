package info.dmerej;

public class MockAuthorizer implements Authorizer{
    private boolean authorized;

    public MockAuthorizer (boolean authorized){
        this.authorized = authorized;
    }
    @Override
    public boolean authorize() {
        return authorized;
    }
}
