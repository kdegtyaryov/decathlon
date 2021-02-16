package score;

import org.example.decathlon.model.AthleteResults;
import org.example.decathlon.model.AthleteResultsImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Konstanin Degtyaryov on 16.02.2021.
 */
public class TotalScoreTest {
    @Test
    public void checkTotalPoints() {
        AthleteResults athleteResults = new AthleteResultsImpl.Builder()
                .withDistance100(10.395)
                .withLongJump(776)
                .withShotPut(18.40)
                .withHighJump(220)
                .withDistance400(46.17)
                .withHurdles110(13.8)
                .withDiscusThrow(56.17)
                .withPoleVault(528)
                .withJavelinThrow(77.19)
                .withDistance1500(233.79)
                .build();
        athleteResults.print();
        assertEquals(athleteResults.getTotalPoints(), 9990);
    }
}
