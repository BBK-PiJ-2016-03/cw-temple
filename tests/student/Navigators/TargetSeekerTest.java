package student.Navigators;

import game.NodeStatus;
import org.junit.Before;
import org.junit.Test;
import student.Maps.CavernMap;
import student.Maps.CavernMapImpl;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static student.TestHelperMethods.getMockNeighbours;
import static student.TestHelperMethods.populateCavern;


/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TargetSeekerTest {

    private CavernMap map;
    private Navigator navigator;
    private Seeker seeker;
    private Collection<NodeStatus> neighbours;

    @Before
    public void before(){
        map = new CavernMapImpl();
        navigator = new DijkstraNavigator(map);
        seeker = new TargetSeeker(navigator, map);
        populateCavern(map);
        neighbours = getMockNeighbours(1);
    }

    @Test(expected=IllegalStateException.class)
    public void getNextMoveUnknownLocation() throws Exception {
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

}