package info.dmerej;

import org.junit.Assert;

import org.junit.Test;


public class SafeCalculatorTest {
  @Test
  public void should_not_throw_when_authorized() {
    //init
    Authorizer authorizer = new MockAuthorizer(true);
    SafeCalculator safeCalculator = new SafeCalculator(authorizer);

    //treatment
    int res = safeCalculator.add(1, 2);

    // test
    Assert.assertEquals(3, res);
  }
}
