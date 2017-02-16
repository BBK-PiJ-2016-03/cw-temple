package student.Maps;

import student.Nodes.CavernNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
public class EscapeCavernMapImpl extends CavernMapImpl implements EscapeCavernMap {

    private Map<CavernNode, Integer> goldMap;
    private CavernNode exit;

    {
        goldMap = new HashMap<>();
    }

    @Override
    public void setNodeGold(CavernNode node, int gold) throws IllegalArgumentException {
        goldMap.put(node, gold);
    }

    @Override
    public int getNodeGold(CavernNode node) {
        return goldMap.get(node);
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
