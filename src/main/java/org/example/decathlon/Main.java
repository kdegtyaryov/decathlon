package org.example.decathlon;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.input.AthleteResultSetReaderImpl;

import java.util.List;

/**
 * Created by Konstanin Degtyaryov on 17.02.2021.
 */
public class Main {
    public static void main(String[] args) {
        List<AthleteResults> results = new AthleteResultSetReaderImpl().readFromFile("src/main/resources/input.csv");
        System.out.println(new ResultProcessor().sortResults(results));
    }
}

