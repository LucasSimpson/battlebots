package player001.predicates;

import battlecode.common.Direction;
import battlecode.common.RobotController;

/**
 * Created by lucas on 14/07/17.
 */
public class CanPlantTreePredicate implements Predicate {
    private final RobotController rc;

    public CanPlantTreePredicate(RobotController rc) {
        this.rc = rc;
    }

    @Override
    public void init() {
    }

    @Override
    public void tick() {
    }

    @Override
    public boolean isTrue() {
        return this.rc.canPlantTree(new Direction(0, 1));
    }
}
