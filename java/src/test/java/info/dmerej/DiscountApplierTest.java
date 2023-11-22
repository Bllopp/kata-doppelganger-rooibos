package info.dmerej;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

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
    Notifier mockNotifier = Mockito.mock(Notifier.class);
    DiscountApplier discountApplier = new DiscountApplier(mockNotifier);

    //treatment
    discountApplier.applyV1(discount,users);

    //test
    Mockito.verify(mockNotifier, Mockito.times(2)).notify(Mockito.any(), Mockito.any());
  }

  @Test
  public void should_notify_twice_when_applying_discount_for_two_users_v2() {
    List<User> users = new ArrayList<User>();
    users.add(new User("Jhon", "jhon.test@ohz.zzr"));
    users.add(new User("Jeanne", "jeanne.test@ohz.zzr"));
    int discount = 15;
    Notifier notifier = Mockito.mock(Notifier.class);
    DiscountApplier discountApplier = new DiscountApplier(notifier);

    //treatment
    discountApplier.applyV2(discount,users);

    //test
    Mockito.verify(notifier).notify(users.get(0), "You've got a new discount of 15%");
    Mockito.verify(notifier).notify(users.get(1),"You've got a new discount of 15%");
  }

}


