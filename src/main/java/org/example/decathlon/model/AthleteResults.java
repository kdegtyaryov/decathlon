package org.example.decathlon.model;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public interface AthleteResults extends Comparable<AthleteResults>{
    public int getEventPoints(Event e);
    public int getTotalPoints();
    public void setPlace(String place);
    public String getPlace();
    public void print();
}
