package org.example.decathlon.model;

import java.util.*;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public class AthleteResultsImpl implements AthleteResults {
    private List<EventResult> athleteEventResults;
    private String name;
    private int totalPoints;
    private String place;
    private final String outputFormatter = "|%7s|%11s|%10s|%11s|%7s|%15s|%14s|%12s|%15s|%8s|%12s|%8s|";

    private AthleteResultsImpl(final Builder builder) {
        // Check all events provided
        if (!Arrays.asList(Event.values()).stream().allMatch(a -> builder.eventResultImpls.stream().anyMatch(res -> res.getEvent().equals(a)))) {
            throw new RuntimeException("All athlete results must be provided.");
        }

        // Calculate total score
        builder.eventResultImpls.stream().forEach(a -> totalPoints += a.getEventPoints());

        // Return new instance
        this.athleteEventResults = builder.eventResultImpls;
        this.name = builder.name;
    }

    public int getEventPoints(Event e) {
        Optional<EventResult> res = athleteEventResults.stream().filter(a -> a.getEvent().equals(e)).findFirst();
        if (!res.isPresent()) {
            throw new RuntimeException("Result for " + e.toString() + " not found");
        }
        return res.get().getEventPoints();
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return this.place;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(System.lineSeparator())
                .append(String.format(outputFormatter
                        , Event.Distance100.name
                        , Event.LongJump.name
                        , Event.ShotPut.name
                        , Event.HighJump.name
                        , Event.Distance400.name
                        , Event.Hurdles110.name
                        , Event.DiscusThrow.name
                        , Event.PoleVault.name
                        , Event.JavelinThrow.name
                        , Event.Distance1500.name
                        , "Total score"
                        , "Place"
                ))
                .append(System.lineSeparator())
                .append(String.format(outputFormatter,
                        this.getEventPoints(Event.Distance100)
                        , this.getEventPoints(Event.LongJump)
                        , this.getEventPoints(Event.ShotPut)
                        , this.getEventPoints(Event.HighJump)
                        , this.getEventPoints(Event.Distance400)
                        , this.getEventPoints(Event.Hurdles110)
                        , this.getEventPoints(Event.DiscusThrow)
                        , this.getEventPoints(Event.PoleVault)
                        , this.getEventPoints(Event.JavelinThrow)
                        , this.getEventPoints(Event.Distance1500)
                        , this.getTotalPoints()
                        , this.getPlace()
                ))
                .toString();
    }

    @Override
    public int compareTo(AthleteResults o) {
        return Integer.compare(this.totalPoints, o.getTotalPoints());
    }

    public static class Builder {
        List<EventResult> eventResultImpls = new ArrayList<>();
        String name;

        public Builder() {
        }

        public AthleteResultsImpl build() {
            return new AthleteResultsImpl(this);
        }

        public Builder withDistance100(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance100, value));
            return this;
        }

        public Builder withDistance100(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance100, value));
            return this;
        }

        public Builder withLongJump(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.LongJump, value));
            return this;
        }

        public Builder withLongJump(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.LongJump, value));
            return this;
        }

        public Builder withShotPut(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.ShotPut, value));
            return this;
        }

        public Builder withShotPut(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.ShotPut, value));
            return this;
        }

        public Builder withHighJump(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.HighJump, value));
            return this;
        }

        public Builder withHighJump(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.HighJump, value));
            return this;
        }

        public Builder withDistance400(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance400, value));
            return this;
        }

        public Builder withDistance400(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance400, value));
            return this;
        }

        public Builder withHurdles110(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Hurdles110, value));
            return this;
        }

        public Builder withHurdles110(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Hurdles110, value));
            return this;
        }

        public Builder withDiscusThrow(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.DiscusThrow, value));
            return this;
        }

        public Builder withDiscusThrow(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.DiscusThrow, value));
            return this;
        }

        public Builder withPoleVault(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.PoleVault, value));
            return this;
        }

        public Builder withPoleVault(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.PoleVault, value));
            return this;
        }

        public Builder withJavelinThrow(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.JavelinThrow, value));
            return this;
        }

        public Builder withJavelinThrow(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.JavelinThrow, value));
            return this;
        }

        public Builder withDistance1500(String value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance1500, value));
            return this;
        }

        public Builder withDistance1500(double value) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance1500, value));
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

    }
}
