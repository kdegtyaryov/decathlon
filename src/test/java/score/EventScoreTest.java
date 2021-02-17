package score;

import org.example.decathlon.model.Event;
import org.example.decathlon.model.EventResult;
import org.example.decathlon.model.EventResultImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Konstanin Degtyaryov on 16.02.2021.
 */
@RunWith(Parameterized.class)
public class EventScoreTest {
    private final Event e;
    private final String stringP;
    private final Double doubleP;
    private final int eventScore;

    public EventScoreTest(Event e, String stringP, Double doubleP, int eventScore) {
        this.e = e;
        this.stringP = stringP;
        this.doubleP = doubleP;
        this.eventScore = eventScore;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {Event.Distance100, "10.395", 10.395, 1000},
                {Event.LongJump, "7.76", 776.00, 1000},
                {Event.ShotPut, "18.40", 18.40, 1000},
                {Event.HighJump, "2.20", 220.00, 992}, // wikipedia error, see https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwintens--7uAhVxxIsKHTlNA0kQFjACegQIAhAC&url=https%3A%2F%2Fwww.iaaf.org%2Fdownload%2Fdownload%3Ffilename%3D53f7d332-be0c-434c-8467-1d9078966147.pdf%26urlslug%3DIAAF%2520Scoring%2520Tables%2520for%2520Combined%2520Events&usg=AOvVaw37p6ZjP6uEzuykhVA0sQcf
                {Event.Distance400, "46.17", 46.17, 1000},
                {Event.Hurdles110, "13.80", 13.80, 1000},
                {Event.DiscusThrow, "56.17", 56.17, 1000},
                {Event.PoleVault, "5.28", 528.00, 998}, // wikipedia error, see https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwintens--7uAhVxxIsKHTlNA0kQFjACegQIAhAC&url=https%3A%2F%2Fwww.iaaf.org%2Fdownload%2Fdownload%3Ffilename%3D53f7d332-be0c-434c-8467-1d9078966147.pdf%26urlslug%3DIAAF%2520Scoring%2520Tables%2520for%2520Combined%2520Events&usg=AOvVaw37p6ZjP6uEzuykhVA0sQcf
                {Event.JavelinThrow, "77.19", 77.19, 1000},
                {Event.Distance1500, "3.53.79", 233.79, 1000},
        });
    }

    @Test
    public void checkEventResultScore() {
        EventResult eventResult = new EventResultImpl(e, stringP, doubleP);
        assertEquals(eventResult.getEventScore(), eventScore);
    }

}
