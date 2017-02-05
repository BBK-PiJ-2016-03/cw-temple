package student;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class DijkstraNavigatorTest {

    private CavernMap map;
    private DijkstraNavigator nav;

    private void populateCavern(CavernMap map) {
        for(int i = 1; i <= 50; i++){
            map.addNode(generateNode(i));
            if(i > 1)
                map.connectNodes(generateNode(i-1), generateNode(i));
        }
        map.connectNodes(generateNode(4), generateNode(50));
    }

    private CavernNode generateNode(int id) {
        CavernNode node = new CavernNodeImpl();
        node.setId(id);
        return node;
    }

    @Before
    public void before(){
        map = new CavernMapImpl();
        populateCavern(map);
        nav = new DijkstraNavigator(map);
    }

    @Test(expected=IllegalStateException.class)
    public void getPathThrowsOnUnsetStartAndDestination() {
        nav.getPathFromStartToDestination();
    }

    @Test(expected=IllegalStateException.class)
    public void getPathThrowsOnUnsetStartOnly() {
        nav.setDestinationNode(generateNode(5));
        nav.getPathFromStartToDestination();
    }

    @Test(expected=IllegalStateException.class)
    public void getPathThrowsOnUnsetDestinationOnly() {
        nav.setStartNode(generateNode(5));
        nav.getPathFromStartToDestination();
    }

    @Test
    public void getPathFromStartToDestination(){
        nav.setStartNode(generateNode(1));
        nav.setDestinationNode(generateNode(50));
        List<CavernNode> expected =  Arrays.asList(generateNode(1),
                                                    generateNode(2),
                                                    generateNode(3),
                                                    generateNode(4),
                                                    generateNode(50));

        assertEquals(expected, nav.getPathFromStartToDestination());
    }

    @Test
    public void initialiseAllNodes(){
        CavernNode start = generateNode(1);
        nav.setStartNode(start);
        nav.setDestinationNode(generateNode(50));

        setAllNodesUninitialised();
        nav.initialiseAllNodes();
        assertAllNodesCorrectlyInitialised(start);
    }

    private void assertAllNodesCorrectlyInitialised(CavernNode start) {
        map.getAllNodes().forEach(e -> {
            assertTrue(e.isGoldenValue() == false);
            if(e.equals(start))
                assertTrue(e.getPathValue() == 0);
            else
                assertTrue(e.getPathValue() == Integer.MAX_VALUE);
        });
    }

    private void setAllNodesUninitialised() {
        map.getAllNodes().forEach(e -> {
            e.setGoldenValue(true);
            e.setPathValue(5);
        });
    }

}