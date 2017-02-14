package student.Maps;

import student.Nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
public class EscapeCavernMapImpl extends CavernMapImpl implements EscapeCavernMap {
    private CavernNode exit;

    @Override
    public void setNodeGold(CavernNode node, int gold) throws IllegalArgumentException {

    }

    @Override
    public int getNodeGold(CavernNode node) {
        return 0;
    }

    @Override
    public void setExit(CavernNode node) {
        this.exit = node;
    }

    @Override
    public CavernNode getExit() {
        return this.exit;
    }
}
