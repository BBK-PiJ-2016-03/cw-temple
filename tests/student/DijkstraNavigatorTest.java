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
            CavernNode currentNode = generateNode(i);
            map.addNode(currentNode);
            if(i > 1)
                map.connectNodes(map.getNode(i-1), currentNode);
        }
        map.connectNodes(map.getNode(4), map.getNode(50));
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
        nav.setDestinationNode(map.getNode(5));
        nav.getPathFromStartToDestination();
    }

    @Test(expected=IllegalStateException.class)
    public void getPathThrowsOnUnsetDestinationOnly() {
        nav.setStartNode(map.getNode(5));
        nav.getPathFromStartToDestination();
    }

    @Test
    public void getPathFromStartToDestination(){
        nav.setStartNode(map.getNode(1));
        nav.setDestinationNode(map.getNode(50));
        List<CavernNode> expected =  Arrays.asList(map.getNode(1),
                map.getNode(2),
                map.getNode(3),
                map.getNode(4),
                map.getNode(50));

        assertEquals(expected, nav.getPathFromStartToDestination());
    }

    @Test
    public void initialiseAllNodes(){
        CavernNode start = map.getNode(1);
        nav.setStartNode(start);
        nav.setDestinationNode(map.getNode(50));

        setAllNodesUninitialised();
        nav.initialiseAllNodes();
        assertAllNodesCorrectlyInitialised(start);
    }

    private void assertAllNodesCorrectlyInitialised(CavernNode start) {
        map.getAllNodes().forEach(e -> {
            if(e.equals(start))
                assertTrue(e.getPathValue() == 0);
            else
                assertTrue(e.getPathValue() == Integer.MAX_VALUE);
        });
    }

    private void setAllNodesUninitialised() {
        map.getAllNodes().forEach(e -> {
            e.setPathValue(5);
        });
    }

}