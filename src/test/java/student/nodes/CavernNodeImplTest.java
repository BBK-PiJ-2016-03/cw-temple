package student.nodes;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public class CavernNodeImplTest {
    private CavernNode node;
    private final Random rand;

    {
        rand = new Random();
    }

    @Before
    public void before(){
        node = new CavernNodeImpl();
    }

    @Test
    public void getDefaultPathValue(){
        assertEquals(Integer.MAX_VALUE, node.getPathValue());
    }

    @Test
    public void getPathValueAfterSet(){
        int testValue = 8;
        node.setPathValue(testValue);
        assertEquals(testValue, node.getPathValue());
    }

    @Test
    public void setPathValueValid(){
        int testValue = 999999999;
        node.setPathValue(testValue);
        assertEquals(testValue, node.getPathValue());
    }

    @Test
    public void setPathValueZero(){
        int testValue = 0;
        node.setPathValue(testValue);
        assertEquals(testValue, node.getPathValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void setPathValueInValid(){
        node.setPathValue(-5);
    }

    @Test(expected=IllegalStateException.class)
    public void getDefaultId(){
        node.getId();
    }

    @Test
    public void setId(){
        long testValue = 500L;
        node.setId(testValue);
        assertEquals(testValue, node.getId());
    }

    @Test
    public void setMinimumId(){
        long testValue = 1L;
        node.setId(testValue);
        assertEquals(testValue, node.getId());
    }

    @Test
    public void setMaximumId(){
        long testValue = Long.MAX_VALUE;
        node.setId(testValue);
        assertEquals(testValue, node.getId());
    }

    @Test
    public void setValidZeroId(){
        long testValue = 0L;
        node.setId(testValue);
        assertEquals(testValue, node.getId());
    }

    @Test(expected=IllegalArgumentException.class)
    public void setInvalidNegativeId(){
        long testValue = -10L;
        node.setId(testValue);
        assertEquals(testValue, node.getId());
    }

    @Test
    public void sameIdAreEqual(){
        long id = 12L;
        node.setId(id);
        CavernNode node2 = new CavernNodeImpl();
        node2.setId(id);

        assertTrue(node.equals(node2));
    }

    @Test
    public void differentIdAreUnequal(){
        long id1 = 12L, id2 = 14L;
        node.setId(id1);
        CavernNode node2 = new CavernNodeImpl();
        node2.setId(id2);

        assertFalse(node.equals(node2));
    }

    @Test
    public void isVisitedFalseTest(){
        Boolean expected = false;
        assertEquals(expected, node.isVisited());
    }

    @Test
    public void isVisitedTrueTest(){
        node.setVisited(true);
        Boolean expected = true;
        assertEquals(expected, node.isVisited());
    }

    @Test
    public void isVisitedToggleFalseTest(){
        node.setVisited(true);
        node.setVisited(false);
        Boolean expected = false;
        assertEquals(expected, node.isVisited());
    }

    @Test
    public void isVisitedToggleTrueTest(){
        node.setVisited(false);
        node.setVisited(true);
        Boolean expected = true;
        assertEquals(expected, node.isVisited());
    }

    @Test
    public void getDistanceDefault(){
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, node.getDistance());
    }

    @Test
    public void setDistanceTestRandom(){
        for(int i = 0; i < 1000; i++) {
            int expected = Math.abs(rand.nextInt());
            node.setDistance(expected);
            assertEquals(expected, node.getDistance());
        }
    }

    @Test
    public void setDistanceTestZero(){
        int expected = 0;
        node.setDistance(expected);
        assertEquals(expected, node.getDistance());
    }

    @Test(expected=IllegalArgumentException.class)
    public void setDistanceTestNegative(){
        int negative = -100;
        node.setDistance(negative);
    }
}