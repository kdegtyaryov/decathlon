package org.example.decathlon.model;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public class EventResultImpl implements EventResult {
    private Event event;
    private double value;

    public EventResultImpl(Event event, String value) {
        switch (event.unit) {
            case METERS:
                this.value = Double.parseDouble(value);
                break;
            case CENTIMETERS:
                this.value = Double.parseDouble(value)*100;
                break;
            case SECONDS:
                String[] timeParts = value.split("\\.");
                this.value = Double.parseDouble(timeParts[0])*60 + Double.parseDouble(timeParts[1]) + Double.parseDouble(timeParts[2])/100;
                break;
        }
        this.event = event;
    }

    public EventResultImpl(Event event, double value) {
        this.event = event;
        this.value = value;
    }

    public int getEventPoints() {
        return event.function.apply(event, value).intValue();
    }

    public Event getEvent() {
        return this.event;
    }

    @Override
    public String toString() {
        return event.getName() + ":" + value;
    }
}
