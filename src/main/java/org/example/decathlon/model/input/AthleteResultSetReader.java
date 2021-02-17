package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;
import java.util.List;

/**
 * Represent a reader for loading event results from a file.
 */
public interface AthleteResultSetReader {
    List<AthleteResults> readFromFile(String s);
}
