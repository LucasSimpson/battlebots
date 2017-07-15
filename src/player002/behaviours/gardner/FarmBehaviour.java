package player002.behaviours.gardner;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.TreeInfo;
import player002.behaviours.RobotBehaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lucas on 14/07/17.
 */
public class FarmBehaviour extends RobotBehaviour {
    private static final String name = "FarmBehaviour";

    public FarmBehaviour(RobotController rc) {
        super(rc);
    }

    @Override
    public void doStep() throws GameActionException {
        // some random direction
        Direction someDirection = new Direction(0, 1);

        // sense trees
        List<TreeInfo> trees = new ArrayList<>(Arrays.asList(this.rc.senseNearbyTrees()));

        if (trees.size() > 0) {
            // water trees
            for (TreeInfo tree : trees) {
                if (tree.getTeam() == this.rc.getTeam() && tree.health <= 45 && this.rc.canWater(tree.getLocation())) {
                    this.rc.water(tree.getLocation());
                    return;
                }
            }

            // move to tree to water it
            for (TreeInfo tree : trees) {
                if (tree.getTeam() == this.rc.getTeam() && tree.health <= 45) {
                    if (this.tryMove(this.rc.getLocation().directionTo(tree.getLocation()))) {
                        return;
                    }
                }
            }
        }

        // plant a tree
        if (this.rc.canPlantTree(someDirection)) {
            this.rc.plantTree(someDirection);
            return;
        }

        // finished
        this.done = true;
    }

    @Override
    public String getName() {
        return FarmBehaviour.name;
    }
}
