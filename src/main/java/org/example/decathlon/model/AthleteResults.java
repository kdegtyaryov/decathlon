package org.example.decathlon.model;

/**
 * Represent combined athlete results.
 */
public interface AthleteResults {
    public EventResult getEventResult(Event e);
    public int getTotalScore();
    public void setPlace(String place);
    public String getPlace();
    public String getName();
    public void print();
}
