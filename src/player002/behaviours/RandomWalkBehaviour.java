package player002.behaviours;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

/**
 * Created by lucas on 13/07/17.
 *
 * Walk randomly.
 */
public class RandomWalkBehaviour extends RobotBehaviour {
    private static final String name = "RandomWalkBehaviour";

    public RandomWalkBehaviour(RobotController rc) {
        super(rc);
    }

    @Override
    public void doStep() throws GameActionException {
        this.tryMove(this.randomDirection());
    }

    @Override
    public String getName() {
        return RandomWalkBehaviour.name;
    }
}
