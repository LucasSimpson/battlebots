package player001.robots;

import battlecode.common.RobotController;
import player001.behaviours.RandomWalkBehaviour;
import player001.behaviours.archon.BuildGardnerBehaviour;
import player001.fsm.FSM;
import player001.fsm.State;
import player001.fsm.Transition;
import player001.predicates.IsDonePredicate;
import player001.predicates.TimedPredicate;

/**
 * Created by lucas on 13/07/17.
 */
public class Archon {
    public Archon(RobotController rc) {

        // create FSM
        FSM fsm = new FSM();

        // create states
        State randomWalk = new State(new RandomWalkBehaviour(rc));
        State buildGardner = new State(new BuildGardnerBehaviour(rc));

        // randomWalk -> buildGardner
        randomWalk.when(
                new TimedPredicate(20)
        ).then(buildGardner);

        // buildGardner -> randomWalk
        buildGardner.when(
                new IsDonePredicate(buildGardner)
        ).then(randomWalk);

        // push states to fsm
        fsm.pushState(randomWalk);
        fsm.pushState(buildGardner);

        // define starting at random walk
        fsm.startAt(buildGardner);

        // execute
        fsm.execute();
    }
}
