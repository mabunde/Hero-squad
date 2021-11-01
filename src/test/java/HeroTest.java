import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Thor", 16, "lightning", "crypto", "Avengers");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void instantiatesWithHeroName_String() {
        Hero myHero = new Hero("superman", 36, "Enhanced Senses", "fire balls", "Infinity");
        assertEquals("superman", myHero.getHeroName());
    }


}