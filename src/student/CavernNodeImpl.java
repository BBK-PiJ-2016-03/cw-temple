package student;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernNodeImpl implements CavernNode {

    private boolean goldenValue;

    {
        goldenValue = false;
    }

    @Override
    public boolean isGoldenValue() {
        return false;
    }

    @Override
    public void setGoldenValue(boolean value) {
        this.goldenValue = value;
    }

    @Override
    public int getPathValue() {
        return 0;
    }

    @Override
    public void setPathValue(int pathValue) {

    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long pathValue) {

    }
}
