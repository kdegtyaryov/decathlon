package sort;

import org.example.decathlon.ResultProcessor;
import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.input.AthleteResultSetReaderImpl;
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
        List<AthleteResults> results = new AthleteResultSetReaderImpl().readFromFile(pathToEthalonFile);
        System.out.println(results);

        results = new ResultProcessor().sortResults(results);
        assertEquals(Integer.compare(results.get(0).getTotalScore(), results.get(1).getTotalScore()), 0);
        assertEquals(results.get(0).getPlace(), results.get(1).getPlace());
        assertEquals(results.get(0).getPlace(), "1-2");
        assertEquals(results.get(6).getPlace(), "7");
        System.out.println(results);
    }
}
