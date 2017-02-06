package student.Navigators;

import student.Maps.CavernMap;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TargetSeeker implements Seeker {

    private Navigator navigator;
    private CavernMap map;
    private long currentLocationId;

    public TargetSeeker(Navigator nav, CavernMap map) {
        setNav(nav);
        setMap(map);
    }

    @Override
    public long getNextMove(long location) {
        return 0;
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void setNav(Navigator nav) {
        this.navigator = nav;
    }

    public CavernMap getMap() {
        return this.map;
    }

    public void setMap(CavernMap map) {
        this.map = map;
    }
}
