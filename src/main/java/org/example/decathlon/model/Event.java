package org.example.decathlon.model;

import java.util.function.BiFunction;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public enum Event {
    Distance100(25.4347, 18, 1.81, "100 m", MeasureUnit.METERS, scoreFunction.trackFunction),
    LongJump(0.14354, 220, 1.4, "Long jump", MeasureUnit.CENTIMETERS, scoreFunction.fieldFunction),
    ShotPut(51.39, 1.5, 1.05, "Shot put", MeasureUnit.METERS, scoreFunction.fieldFunction),
    HighJump(0.8465, 75, 1.42, "High jump", MeasureUnit.CENTIMETERS, scoreFunction.fieldFunction),
    Distance400(1.53775, 82, 1.81, "400 m", MeasureUnit.METERS, scoreFunction.trackFunction),
    Hurdles110(5.74352, 28.5, 1.92, "110 m hurdles", MeasureUnit.METERS, scoreFunction.trackFunction),
    DiscusThrow(12.91, 4, 1.1, "Discus throw", MeasureUnit.METERS, scoreFunction.fieldFunction),
    PoleVault(0.2797, 100, 1.35, "Pole vault", MeasureUnit.CENTIMETERS, scoreFunction.fieldFunction),
    JavelinThrow(10.14, 7, 1.08, "Javelin throw", MeasureUnit.METERS, scoreFunction.fieldFunction),
    Distance1500(0.03768, 480, 1.85, "1500 m", MeasureUnit.SECONDS, scoreFunction.trackFunction);

    double a;
    double b;
    double c;
    String name;
    MeasureUnit unit;
    BiFunction<Event,Double,Double> function;

    Event(double a, double b, double c, String name, MeasureUnit unit, BiFunction<Event,Double,Double> scoreCalcFunction) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = name;
        this.unit = unit;
        this.function = scoreCalcFunction;
    }

    public String getName() {
        return name;
    }

    static class scoreFunction {
        public static final BiFunction<Event,Double,Double> trackFunction = (e,p) -> Math.pow(e.b-p, e.c)*e.a;
        public static final BiFunction<Event,Double,Double> fieldFunction = (e,p) -> Math.pow(p-e.b, e.c)*e.a;
    }

}

