package student.navigators;

import org.junit.Before;
import org.junit.Test;
import student.maps.CavernMap;
import student.maps.CavernMapImpl;
import student.nodes.NodeLibrary;
import student.nodes.NodeStatusNeighbourNode;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static student.TestHelperMethods.getMockNeighbours;
import static student.TestHelperMethods.populateCavern;


/**
 * Created by Alexander Worton on 06/02/2017.
 */
@SuppressWarnings("ALL")
public class TargetSeekerTest {

    private CavernMap map;
    private Seeker seeker;
    private Collection<NodeStatusNeighbourNode> neighbours;

    @Before
    public void before(){
        map = new CavernMapImpl();
        Navigator navigator = new DijkstraNavigator(map);
        seeker = new TargetSeeker(navigator, map);
        populateCavern(map);
        neighbours = NodeLibrary.wrapGameNodeStatusCollection(getMockNeighbours(1));
    }

    @Test(expected=IllegalStateException.class)
    public void getNextMoveUnknownLocation(){
        seeker.getNextMove(99999999L, neighbours);
    }

    @Test
    public void getNextMoveKnownLocationNeighbours(){
        //valid nodes from populateCavern are 1-50. Each node is connected in turn, plus a connection from  4 to 50
        long expected = 2L;
        assertEquals(expected, seeker.getNextMove(1L, neighbours));
    }

    @Test
    public void getNextMoveKnownLocationNoNeighbours(){
        //valid nodes from populateCavern are 1-50. Each node is connected in turn, plus a connection from  4 to 50
        long expected = 2L;
        assertEquals(expected, seeker.getNextMove(1L, neighbours));
    }

    @Test
    public void getNextMoveAsPath(){
        map.getNode(3).setDistance(95);
        map.getNode(2).setDistance(90);
        map.getNode(2).setVisited(true);
        map.getNode(1).setDistance(85);
        map.getNode(1).setVisited(true);

        long expected = 2L;
        assertEquals(expected, seeker.getNextMove(1L, new ArrayList<>()));

        expected = 3L;
        assertEquals(expected, seeker.getNextMove(2L, new ArrayList<>()));
    }

    @Test
    public void nodesMarkedAsVisited(){
        assertFalse(map.getNode(1L).isVisited());
        seeker.getNextMove(1L, new ArrayList<>());
        assertTrue(map.getNode(1L).isVisited());
    }

}