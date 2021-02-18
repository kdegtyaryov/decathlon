package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 * Implements the reader for loading event results from a file.
 */
public class AthleteResultsFileScannerReader extends AthleteResultsAbstractScannerReader implements AthleteResultsReader {
    String fileName;
    /*
    Read data from file.
     */
    public AthleteResultsFileScannerReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<AthleteResults> read() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect file name.");
        }
        this.scanner = scanner;
        return parse();
    }
}
