package player001.behaviours.archon;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import player001.behaviours.Behaviour;
import player001.behaviours.RobotBehaviour;

/**
 * Created by lucas on 15/07/17.
 */
public class DonateBehaviour extends RobotBehaviour{
    private static final String name = "DonateBehaviour";

    public DonateBehaviour(RobotController rc) {
        super(rc);
    }


    @Override
    public void doStep() throws GameActionException {
        float numBullets = this.rc.getTeamBullets();
        float cost = this.rc.getVictoryPointCost();

        if (numBullets > cost && numBullets > 100) {
            this.rc.donate((int)(numBullets-100) / cost);
        }

        this.done = true;
    }

    @Override
    public String getName() {
        return DonateBehaviour.name;
    }
}
