package sort;

import org.example.decathlon.ResultProcessor;
import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.input.AthleteResultSetReader;
import org.example.decathlon.model.input.AthleteResultSetReaderImpl;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Konstanin Degtyaryov on 16.02.2021.
 */
public class IntegrationTest {
    public static void main(String[] args) {
        List<AthleteResults> results = new AthleteResultSetReaderImpl().readFromFile("src/test/resources/input_ethalon.csv");
        System.out.println(results);

        System.out.println(new ResultProcessor().sortResults(results));
    }
}
