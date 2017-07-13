package player001.behaviours;

import battlecode.common.*;

import java.util.Optional;

/**
 * Created by lucas on 13/07/17.
 * <p>
 * Runs in the opposite direction of the closest Robot within a given radius
 */
public class RunAwayBehaviour extends RobotBehaviour {
    private static final String name = "RunAwayBehaviour";
    private RobotType[] typesToAvoid;
    private int senseDistance;

    public RunAwayBehaviour(RobotController rc, RobotType[] typesToAvoid, int senseDistance) {
        super(rc);

        this.typesToAvoid = typesToAvoid;
        this.senseDistance = senseDistance;
    }

    @Override
    public void doStep() throws GameActionException {
        RobotInfo[] robots = this.rc.senseNearbyRobots(this.senseDistance);

        // robots is in order of closest first; scan for types to avoid then move in opposite direction
        Optional<RobotInfo> toRunAwayFrom = Optional.empty();
        for (RobotInfo robot : robots) {
            if (!toRunAwayFrom.isPresent()) {
                for (RobotType typeToAvoid : this.typesToAvoid) {
                    if (robot.type == typeToAvoid) {
                        toRunAwayFrom = Optional.of(robot);
                        break;
                    }
                }
            }
        }

        // done is no hit
        if (!toRunAwayFrom.isPresent()) {
            this.done = true;
            return;
        }

        // get direction
        MapLocation robotLocation = toRunAwayFrom.get().getLocation();
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
