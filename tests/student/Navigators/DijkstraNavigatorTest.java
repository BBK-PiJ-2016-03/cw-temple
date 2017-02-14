package student.Navigators;

import org.junit.Before;
import org.junit.Test;
import student.Maps.CavernMap;
import student.Maps.CavernMapImpl;
import student.Nodes.CavernNode;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static student.TestHelperMethods.populateCavern;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class DijkstraNavigatorTest {

    private CavernMap map;
    private DijkstraNavigator nav;

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

    @Test
    public void getShortestDistanceToDestinationOneNodeTest(){
        nav.setStartNode(map.getNode(1L));
        nav.setDestinationNode(map.getNode(2L));
        int expected = 1;
        assertEquals(expected, nav.getShortestDistanceToDestination());
    }

    @Test
    public void getShortestDistanceToDestinationThreeNodesTest(){
        nav.setStartNode(map.getNode(1L));
        nav.setDestinationNode(map.getNode(4L));
        int expected = 3;
        assertEquals(expected, nav.getShortestDistanceToDestination());
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