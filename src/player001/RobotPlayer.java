package player001;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import player001.robots.Archon;
import player001.robots.Gardner;


/**
 * Created by lucas on 12/07/17.
 */
public class RobotPlayer {

    public static void run(RobotController rc) throws GameActionException {

        // This is the RobotController object. You use it to perform actions from this robot,
        // and to get information on its current status.
        // Here, we've separated the controls into a different method for each RobotType.
        // You can add the missing ones or rewrite this into your own control structure.
        switch (rc.getType()) {
            case ARCHON:
                new Archon(rc);
//                new Archon(rc).run();
                break;
            case GARDENER:
                new Gardner(rc);
//                new Gardner(rc).run();
                break;
            case SOLDIER:
//                new BaseRobot(rc).run();
//                runSoldier(rc);
                break;
            case LUMBERJACK:
//                new BaseRobot(rc).run();
//                runLumberjack(rc);
                break;
        }
    }
}
