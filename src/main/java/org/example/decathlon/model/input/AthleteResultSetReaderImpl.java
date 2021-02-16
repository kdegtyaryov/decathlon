package org.example.decathlon.model.input;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.AthleteResultsImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Konstanin Degtyaryov on 15.02.2021.
 */
public class AthleteResultSetReaderImpl implements AthleteResultSetReader {
    @Override
    public List<AthleteResults> readFromFile(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect file name.");
        }
        return read(scanner);
    }

    @Override
    public List<AthleteResults> readFromConsole() {
        Scanner scanner = null;
        return read(scanner);
    }

    private List<AthleteResults> read(Scanner scanner) {
        List<AthleteResults> athleteResultsList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");
            String[] times = (fields[10]).split("\\.");

            AthleteResults athleteResults = new AthleteResultsImpl.Builder()
                    .withName(fields[0])
                    .withDistance100(fields[1])
                    .withLongJump(fields[2])
                    .withShotPut(fields[3])
                    .withHighJump(fields[4])
                    .withDistance400(fields[5])
                    .withHurdles110(fields[6])
                    .withDiscusThrow(fields[7])
                    .withPoleVault(fields[8])
                    .withJavelinThrow(fields[9])
                    .withDistance1500(fields[10])
                    .build();
            athleteResultsList.add(athleteResults);
        }
        return athleteResultsList;
    }
}
