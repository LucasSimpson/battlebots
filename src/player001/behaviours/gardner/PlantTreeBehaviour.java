package player001.behaviours.gardner;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import player001.behaviours.Behaviour;
import player001.behaviours.RobotBehaviour;

/**
 * Created by lucas on 14/07/17.
 */
public class PlantTreeBehaviour extends RobotBehaviour {
    private static final String name = "PlantTreeBehaviour";

    public PlantTreeBehaviour(RobotController rc) {
        super(rc);
    }

    @Override
    public void doStep() throws GameActionException {
        this.rc.plantTree(new Direction(0, 1));
        this.done = true;
    }

    @Override
    public String getName() {
        return PlantTreeBehaviour.name;
    }
}
