package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.AthleteResultsImpl;
import org.example.decathlon.model.utils.Convertor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implements the reader for loading event results from a file.
 */
public class AthleteResultsFileReaderImpl extends AthleteResultsAbstractReaderImpl implements AthleteResultsReader {
    String fileName;
    /*
    Read data from file.
     */
    public AthleteResultsFileReaderImpl(String fileName) {
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
