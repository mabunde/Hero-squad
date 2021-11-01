import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad mySquad = new Squad("marvel", "6", "computer illiteracy");
        assertEquals(true, mySquad instanceof Squad);
    }

    @Test
    public void returnsAllInstancesOfSquad_true() {
        Squad fsquad = new Squad("marvel", "6", "computer illiteracy");
        Squad squad = new Squad("Endgame", "5", "sexism");
        assertEquals(true, Squad.all().contains(fsquad));
        assertEquals(true, Squad.all().contains(squad));
    }
    @Test
    public void clearSquadFromArray() {
        Squad firstSquad = new Squad("Endgame", "5", "sexism");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }
    @After
    public void tearDown() throws Exception {
    }
}