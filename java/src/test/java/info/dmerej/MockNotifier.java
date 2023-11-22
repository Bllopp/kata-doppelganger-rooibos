package info.dmerej;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MockNotifier implements Notifier{
    @Getter
    private int nbNotify = 0;
    @Getter
    private List<User> users = new ArrayList<User>();

    public void notify(User user, String message) {
        nbNotify++;
        users.add(user);
    }
}
