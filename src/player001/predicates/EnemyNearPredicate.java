package player001.predicates;

import battlecode.common.RobotController;
import battlecode.common.RobotInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return new ArrayList<>(Arrays.asList(this.rc.senseNearbyRobots()))
                .stream()
                .filter(robot -> robot.getTeam() != this.rc.getTeam())
                .collect(Collectors.toList())
                .size() > 0;
    }
}
