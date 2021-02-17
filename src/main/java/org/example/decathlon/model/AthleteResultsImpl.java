package org.example.decathlon.model;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Represent combined athlete results.
 */
public class AthleteResultsImpl implements AthleteResults {
    private final String OUTPUT_FORMATTER = "|%10s|%7s|%11s|%10s|%11s|%7s|%15s|%14s|%12s|%15s|%8s|%12s|%8s|";

    private List<EventResult> athleteResults;
    private String name;
    private int totalScore;
    private String place;

    private AthleteResultsImpl(final Builder builder) {
        // Check all events provided
        if (!Arrays.asList(Event.values()).stream().allMatch(a -> builder.eventResultImpls.stream().anyMatch(res -> res.getEvent().equals(a)))) {
            throw new RuntimeException("All athlete results must be provided.");
        }

        if (builder.name == null || builder.name.length() == 0) {
            throw new RuntimeException("Name of an athlete must be provided.");
        }

        // Calculate total score
        builder.eventResultImpls.stream().forEach(a -> totalScore += a.getEventScore());

        // Return new instance
        this.athleteResults = builder.eventResultImpls;
        this.name = builder.name;
    }

    @Override
    public int getEventScore(Event e) {
        Optional<EventResult> res = athleteResults.stream().filter(a -> a.getEvent().equals(e)).findFirst();
        if (!res.isPresent()) {
            throw new RuntimeException("Result for " + e.toString() + " not found");
        }
        return res.get().getEventScore();
    }

    @Override
    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String getPlace() {
        return this.place;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(System.lineSeparator())
                .append(String.format(OUTPUT_FORMATTER
                        , "Name"
                        , Event.Distance100.getName()
                        , Event.LongJump.getName()
                        , Event.ShotPut.getName()
                        , Event.HighJump.getName()
                        , Event.Distance400.getName()
                        , Event.Hurdles110.getName()
                        , Event.DiscusThrow.getName()
                        , Event.PoleVault.getName()
                        , Event.JavelinThrow.getName()
                        , Event.Distance1500.getName()
                        , "Total score"
                        , "Place"
                ))
                .append(System.lineSeparator())
                .append(String.format(OUTPUT_FORMATTER
                        , this.getName()
                        , this.getEventScore(Event.Distance100)
                        , this.getEventScore(Event.LongJump)
                        , this.getEventScore(Event.ShotPut)
                        , this.getEventScore(Event.HighJump)
                        , this.getEventScore(Event.Distance400)
                        , this.getEventScore(Event.Hurdles110)
                        , this.getEventScore(Event.DiscusThrow)
                        , this.getEventScore(Event.PoleVault)
                        , this.getEventScore(Event.JavelinThrow)
                        , this.getEventScore(Event.Distance1500)
                        , this.getTotalScore()
                        , this.getPlace()
                ))
                .toString();
    }

    public static class Builder {
        List<EventResult> eventResultImpls = new ArrayList<>();
        String name;

        public Builder() {
        }

        public AthleteResultsImpl build() {
            return new AthleteResultsImpl(this);
        }

        public Builder withDistance100(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance100, value, converter.apply(Event.Distance100, value)));
            return this;
        }

        public Builder withLongJump(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.LongJump, value, converter.apply(Event.LongJump, value)));
            return this;
        }

        public Builder withShotPut(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.ShotPut, value, converter.apply(Event.ShotPut, value)));
            return this;
        }

        public Builder withHighJump(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.HighJump, value, converter.apply(Event.HighJump, value)));
            return this;
        }

        public Builder withDistance400(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance400, value, converter.apply(Event.Distance400, value)));
            return this;
        }

        public Builder withHurdles110(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.Hurdles110, value, converter.apply(Event.Hurdles110, value)));
            return this;
        }

        public Builder withDiscusThrow(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.DiscusThrow, value, converter.apply(Event.DiscusThrow, value)));
            return this;
        }

        public Builder withPoleVault(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.PoleVault, value, converter.apply(Event.PoleVault, value)));
            return this;
        }

        public Builder withJavelinThrow(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.JavelinThrow, value, converter.apply(Event.JavelinThrow, value)));
            return this;
        }

        public Builder withDistance1500(String value, BiFunction<Event, String, Double> converter) {
            this.eventResultImpls.add(new EventResultImpl(Event.Distance1500, value, converter.apply(Event.Distance1500, value)));
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

    }
}
