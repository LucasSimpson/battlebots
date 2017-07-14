package player001.predicates;

import battlecode.common.RobotController;
import battlecode.common.RobotInfo;

/**
 * Created by lucas on 13/07/17.
 */
public class EnemyNearPredicate implements Predicate {
    private final int senseDistance;
    private final RobotController rc;

    public EnemyNearPredicate(RobotController rc, int senseDistance) {
        this.rc = rc;
        this.senseDistance = senseDistance;
    }

    @Override
    public void init() {
    }

    @Override
    public void tick() {
    }

    @Override
    public boolean isTrue() {
        for (RobotInfo robot: this.rc.senseNearbyRobots(this.senseDistance)) {
            if (robot.getTeam() != this.rc.getTeam()) {
                return false;
            }
        }
        return true;
    }
}
