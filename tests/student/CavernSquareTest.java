package student;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Alexander Worton on 02/02/2017.
 */
public class CavernSquareTest {

    private Long id;
    private int distanceToTarget;
    private CavernSquare cavernSquare;

    {
        id = 1L;
        distanceToTarget = 50;
    }

    @Before
    public void before(){
        cavernSquare = new CavernSquare(id, distanceToTarget);
    }

    /**
     * check that addDestination adds a destination which is returned from the square
     */
    @Test
    public void addDestination(){
        Long id = 2L;
        int distance = 45;
        CavernSquare newSquare = new CavernSquare(id, distance);
        cavernSquare.addDestination(newSquare);
        assertTrue(cavernSquare.getDestinations().contains(newSquare));
    }

    /**
     * check that the distance to target is correctly reported
     */
    @Test
    public void getDistanceToTarget() {
        assertEquals(distanceToTarget, cavernSquare.getDistanceToTarget());
    }

    @Test
    public void getDestinations(){

    }

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void isExplored() throws Exception {

    }

    @Test
    public void setExplored() throws Exception {

    }

    @Test
    public void isDeadEnd() throws Exception {

    }

    @Test
    public void setDeadEnd() throws Exception {

    }

}