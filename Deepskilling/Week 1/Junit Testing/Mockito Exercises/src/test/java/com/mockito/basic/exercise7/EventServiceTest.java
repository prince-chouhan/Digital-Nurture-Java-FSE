package com.mockito.basic.exercise7;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

/**
 * Basic Exercise 7: Handling Void Methods with Exceptions
 */
public class EventServiceTest {

    @Test
    void testEmitEventThrowsRuntimeException() throws Exception {
        EventPublisher mockPublisher = Mockito.mock(EventPublisher.class);

        doThrow(new RuntimeException("Publish failed")).when(mockPublisher).publish("CRASH_EVENT");

        EventService eventService = new EventService(mockPublisher);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> eventService.emitEvent("CRASH_EVENT"));

        assertEquals("Publish failed", ex.getMessage());
        verify(mockPublisher).publish("CRASH_EVENT");
    }

    @Test
    void testEmitEventThrowsCheckedException() throws Exception {
        EventPublisher mockPublisher = Mockito.mock(EventPublisher.class);

        doThrow(new Exception("Checked error")).when(mockPublisher).publish("BAD_EVENT");

        EventService eventService = new EventService(mockPublisher);

        assertThrows(Exception.class, () -> eventService.emitEvent("BAD_EVENT"));
    }

    @Test
    void testEmitEventSucceedsWithDoNothing() throws Exception {
        EventPublisher mockPublisher = Mockito.mock(EventPublisher.class);

        doNothing().when(mockPublisher).publish("OK_EVENT");

        EventService eventService = new EventService(mockPublisher);

        assertDoesNotThrow(() -> eventService.emitEvent("OK_EVENT"));
        verify(mockPublisher).publish("OK_EVENT");
    }
}
