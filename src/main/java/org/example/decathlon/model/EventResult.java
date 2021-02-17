package org.example.decathlon.model;

/**
 * Represents result for concrete event of an athlete.
 */
public interface EventResult {
    public int getEventScore();
    public String getViewResult();
    public Event getEvent();
}
