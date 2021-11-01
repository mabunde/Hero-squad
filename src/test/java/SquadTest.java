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
    @After
    public void tearDown() throws Exception {
    }
}