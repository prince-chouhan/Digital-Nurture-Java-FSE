package com.mockito.basic.exercise7;

/**
 * Basic Exercise 7: Handling Void Methods with Exceptions
 * EventService wraps EventPublisher and propagates exceptions from the publish call.
 */
public class EventService {

    private final EventPublisher publisher;

    public EventService(EventPublisher publisher) {
        this.publisher = publisher;
    }

    public void emitEvent(String event) throws Exception {
        publisher.publish(event);
    }
}
