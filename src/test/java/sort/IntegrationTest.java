package sort;

import org.example.decathlon.model.input.AthleteResultsReader;
import org.example.decathlon.model.utils.DecathlonResultProcessor;
import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.input.AthleteResultsFileReaderImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Konstanin Degtyaryov on 16.02.2021.
 */
public class IntegrationTest {

    private String pathToEthalonFile;

    public IntegrationTest() {
        pathToEthalonFile = "src/test/resources/input_ethalon.csv";
    }

    @Test
    public void checkSort() {
        AthleteResultsReader reader = new AthleteResultsFileReaderImpl(pathToEthalonFile);
        // Print results before rankins
        System.out.println(reader.read());

        // Print results after rankins
        List<AthleteResults> results = DecathlonResultProcessor.processResults(reader);
        System.out.println(results);

        // Check resutls
        assertEquals(Integer.compare(results.get(0).getTotalScore(), results.get(1).getTotalScore()), 0);
        assertEquals(results.get(0).getPlace(), results.get(1).getPlace());
        assertEquals(results.get(0).getPlace(), "1-2");
        assertEquals(results.get(6).getPlace(), "7");
    }
}
