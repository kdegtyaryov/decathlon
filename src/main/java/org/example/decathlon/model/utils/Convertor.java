package org.example.decathlon.model.utils;

import org.example.decathlon.model.Event;
import java.util.function.BiFunction;

/**
 * Contains functions to convert input event results from external format to inner.
 */
public class Convertor {
    public static final BiFunction<Event,String,Double> stdConverter = new BiFunction<Event, String, Double>() {
        @Override
        public Double apply(Event event, String result) {
            Double doubleResult = null;
            switch (event.getMeasureUnit()) {
                case METERS:
                    doubleResult = Double.parseDouble(result);
                    break;
                case CENTIMETERS:
                    doubleResult = Double.parseDouble(result) * 100;
                    break;
                case SECONDS:
                    String[] timeParts = result.split("\\.");
                    doubleResult = Double.parseDouble(timeParts[0]) * 60 + Double.parseDouble(timeParts[1]) + Double.parseDouble(timeParts[2]) / 100;
                    break;
            }
            return doubleResult;
        }
    };
}
