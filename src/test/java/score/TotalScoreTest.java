package score;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.AthleteResultsImpl;
import org.example.decathlon.model.utils.Convertor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Konstanin Degtyaryov on 16.02.2021.
 */
public class TotalScoreTest {
    @Test
    public void checkTotalPoints() {
        AthleteResults athleteResults = new AthleteResultsImpl.Builder()
                .withName("John Doe")
                .withDistance100("10.395", Convertor.stdConverter)
                .withLongJump("7.76", Convertor.stdConverter)
                .withShotPut("18.40", Convertor.stdConverter)
                .withHighJump("2.20", Convertor.stdConverter)
                .withDistance400("46.17", Convertor.stdConverter)
                .withHurdles110("13.8", Convertor.stdConverter)
                .withDiscusThrow("56.17", Convertor.stdConverter)
                .withPoleVault("5.28", Convertor.stdConverter)
                .withJavelinThrow("77.19", Convertor.stdConverter)
                .withDistance1500("3.53.79", Convertor.stdConverter)
                .build();
        athleteResults.print();
        assertEquals(athleteResults.getTotalScore(), 9990);
    }
}
