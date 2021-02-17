package org.example.decathlon.model;

/**
 * Represents result for concrete event of an athlete.
 */
public class EventResultImpl implements EventResult {
    private Event event;
    private String viewResult;
    private double result;
    private int eventScore;

    public EventResultImpl(Event event, String viewResult, double result) {
        this.event = event;
        this.result = result;
        this.viewResult = viewResult;
        this.eventScore = event.evalScore(this.result);
    }

    @Override
    public int getEventScore() {
        return eventScore;
    }

    @Override
    public String getViewResult() {
        return viewResult;
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return event.getName() + ":" + result;
    }
}
