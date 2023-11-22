package info.dmerej;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest {
  @Test
  public void should_notify_twice_when_applying_discount_for_two_users_v1() {
    //init
    List<User> users = new ArrayList<User>();
    users.add(new User("Jhon", "jhon.test@ohz.zzr"));
    users.add(new User("Jeanne", "jeanne.test@ohz.zzr"));
    int discount = 15;
    MockNotifier mockNotifier = new MockNotifier();
    DiscountApplier discountApplier = new DiscountApplier(mockNotifier);

    //treatment
    discountApplier.applyV1(discount,users);

    //test
    Assert.assertEquals(users.size(),mockNotifier.getNbNotify());
  }

  @Test
  public void should_notify_twice_when_applying_discount_for_two_users_v2() {
    List<User> users = new ArrayList<User>();
    users.add(new User("Jhon", "jhon.test@ohz.zzr"));
    users.add(new User("Jeanne", "jeanne.test@ohz.zzr"));
    int discount = 15;
    MockNotifier mockNotifier = new MockNotifier();
    DiscountApplier discountApplier = new DiscountApplier(mockNotifier);

    discountApplier.applyV2(discount,users);

    Assert.assertEquals(users.size(),mockNotifier.getNbNotify());
    Assert.assertTrue(mockNotifier.getUsers().contains(users.get(0)));
    Assert.assertTrue(mockNotifier.getUsers().contains(users.get(1)));
  }

}
