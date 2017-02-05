package student;

import org.junit.Before;
import org.junit.Test;

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
    public void getPathValue() throws Exception {

    }

    @Test
    public void setPathValue() throws Exception {

    }

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void setId() throws Exception {

    }

}