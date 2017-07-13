package player001.behaviours.archon;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import player001.behaviours.RobotBehaviour;

/**
 * Created by lucas on 13/07/17.
 *
 * Do nothing until Archon can build a Gardner, then do that.
 */
public class BuildGardnerBehaviour extends RobotBehaviour {
    private static final String name = "BuildGardnerBehaviour";

    public BuildGardnerBehaviour(RobotController rc) {
        super(rc);
    }

    @Override
    public void doStep() throws GameActionException {
        Direction dir = this.randomDirection();

        if (this.rc.canHireGardener(dir)) {
            this.rc.hireGardener(dir);
            this.done = true;
        }
    }

    @Override
    public String getName() {
        return BuildGardnerBehaviour.name;
    }
}
