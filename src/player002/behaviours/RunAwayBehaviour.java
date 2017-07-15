package player002.behaviours;

import battlecode.common.*;

import java.util.List;

import static player002.utils.RC.senseAndFilterFriendlies;

/**
 * Created by lucas on 13/07/17.
 * <p>
 * Runs in the opposite direction of the closest Robot within a given radius
 */
public class RunAwayBehaviour extends RobotBehaviour {
    private static final String name = "RunAwayBehaviour";
    private final int senseDistance;

    public RunAwayBehaviour(RobotController rc, int senseDistance) {
        super(rc);

        this.senseDistance = senseDistance;
    }

    @Override
    public void doStep() throws GameActionException {
        // sense robots and filter for only enemies
        List<RobotInfo> robots = senseAndFilterFriendlies(this.rc, this.senseDistance);

        // robots is in order of closest first; scan for types to avoid then move in opposite direction
        if (robots.size() == 0) {
            this.done = true;
            return;
        }

        // get direction
        MapLocation robotLocation = robots.get(0).getLocation();
        MapLocation ourLocation = this.rc.getLocation();
        Direction directionToMove = new Direction(robotLocation.x - ourLocation.x, robotLocation.y - ourLocation.y);

        // move
        this.tryMove(directionToMove);
    }

    @Override
    public String getName() {
        return RunAwayBehaviour.name;
    }

}
