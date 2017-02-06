package student.Navigators;

import org.junit.Before;
import org.junit.Test;
import student.Maps.CavernMap;
import student.Maps.CavernMapImpl;

import static student.TestHelperMethods.populateCavern;


/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TargetSeekerTest {

    private CavernMap map;
    private Navigator navigator;
    private Seeker seeker;

    @Before
    public void before(){
        map = new CavernMapImpl();
        navigator = new DijkstraNavigator(map);
        seeker = new TargetSeeker(navigator, map);
        populateCavern(map);
    }

    @Test(expected=IllegalStateException.class)
    public void getNextMoveUnknownLocation() throws Exception {
        seeker.getNextMove(9999);
    }

}