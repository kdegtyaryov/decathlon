package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.AthleteResultsImpl;
import org.example.decathlon.model.utils.Convertor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represent a reader for loading event results from a file.
 */
public interface AthleteResultsReader {
    public List<AthleteResults> read();
}
