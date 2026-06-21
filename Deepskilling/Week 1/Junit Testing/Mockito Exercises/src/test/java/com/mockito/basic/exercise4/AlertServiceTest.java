package com.mockito.basic.exercise4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/*
 * Basic Exercise 4: Handling Void Methods
 */
public class AlertServiceTest {

    @Test
    void testSendNotificationIsInvoked() {
        NotificationSender mockSender = Mockito.mock(NotificationSender.class);

        doNothing().when(mockSender).sendNotification("Alert: Server Down");

        AlertService alertService = new AlertService(mockSender);
        alertService.triggerAlert("Alert: Server Down");

        verify(mockSender).sendNotification("Alert: Server Down");
    }

    @Test
    void testSendNotificationCalledOnce() {
        NotificationSender mockSender = Mockito.mock(NotificationSender.class);

        AlertService alertService = new AlertService(mockSender);
        alertService.triggerAlert("Test Alert");

        verify(mockSender, times(1)).sendNotification("Test Alert");
    }
}
