package org.example.decathlon;

import org.example.decathlon.model.input.AthleteResultsFileScannerReader;
import org.example.decathlon.model.input.AthleteResultsReader;
import org.example.decathlon.model.utils.DecathlonResultProcessor;

/**
 * Created by Konstanin Degtyaryov on 17.02.2021.
 */
public class Main {
    public static void main(String[] args) {
        // Run this class to process the file input.csv in resources folder.
        String fileName = "src/main/resources/input.csv";
        AthleteResultsReader reader = new AthleteResultsFileScannerReader(fileName);
        System.out.println(DecathlonResultProcessor.processResults(reader));
    }
}

