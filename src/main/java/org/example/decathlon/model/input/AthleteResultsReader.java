package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public interface AthleteResultsReader {
    AthleteResults parse(String s);
}
