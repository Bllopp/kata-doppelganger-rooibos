package info.dmerej;

import lombok.Getter;

public class MockNotifier implements Notifier{
    @Getter
    private int nbNotify = 0;

    public void notify(User user, String message) {
        nbNotify++;
    }
}
