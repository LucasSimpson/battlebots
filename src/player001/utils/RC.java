package player001.utils;

import battlecode.common.RobotController;
import battlecode.common.RobotInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 14/07/17.
 */
public class RC {

    public static List<RobotInfo> senseAndFilterFriendlies(RobotController rc, int senseDistance) {
        // cant use stream -.-
        List<RobotInfo> filteredRobots = new ArrayList<>();
        for (RobotInfo robot: rc.senseNearbyRobots(senseDistance)) {
            if (robot.getTeam() != rc.getTeam()) {
                filteredRobots.add(robot);
            }
        }

        return filteredRobots;
    }
}
