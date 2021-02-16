package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;

import java.util.List;
import java.util.Set;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public interface AthleteResultSetReader {
    List<AthleteResults> readFromFile(String s);
    List<AthleteResults> readFromConsole();
}
