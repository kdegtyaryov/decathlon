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
public class AthleteResultSetReaderImpl implements AthleteResultSetReader {
    /*
    Read data from file.
     */
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

    /*
    Reads data from scanner.
     */
    private List<AthleteResults> read(Scanner scanner) {
        List<AthleteResults> athleteResultsList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");
            String[] times = (fields[10]).split("\\.");

            AthleteResults athleteResults = new AthleteResultsImpl.Builder()
                    .withName(fields[0])
                    .withDistance100(fields[1], Convertor.stdConverter)
                    .withLongJump(fields[2], Convertor.stdConverter)
                    .withShotPut(fields[3], Convertor.stdConverter)
                    .withHighJump(fields[4], Convertor.stdConverter)
                    .withDistance400(fields[5], Convertor.stdConverter)
                    .withHurdles110(fields[6], Convertor.stdConverter)
                    .withDiscusThrow(fields[7], Convertor.stdConverter)
                    .withPoleVault(fields[8], Convertor.stdConverter)
                    .withJavelinThrow(fields[9], Convertor.stdConverter)
                    .withDistance1500(fields[10], Convertor.stdConverter)
                    .build();
            athleteResultsList.add(athleteResults);
        }
        return athleteResultsList;
    }
}
