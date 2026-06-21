package com.mockito.basic.exercise4;

/**
 * Basic Exercise 4: Handling Void Methods
 * AlertService triggers notifications through NotificationSender.
 */
public class AlertService {

    private final NotificationSender sender;

    public AlertService(NotificationSender sender) {
        this.sender = sender;
    }

    public void triggerAlert(String message) {
        sender.sendNotification(message);
    }
}
