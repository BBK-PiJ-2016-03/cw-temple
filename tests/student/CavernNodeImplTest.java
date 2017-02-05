package student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernNodeImplTest {
    private CavernNode node;

    @Before
    public void before(){
        node = new CavernNodeImpl();
    }

    @Test
    public void isGoldenValueFalse(){
        assertFalse(node.isGoldenValue());
    }

    @Test
    public void isGoldenValueTrue(){
        node.setGoldenValue(true);
        assertFalse(node.isGoldenValue());
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

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void setId() throws Exception {

    }

}