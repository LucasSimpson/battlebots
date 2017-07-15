package player001.robots;

import battlecode.common.RobotController;
import player001.behaviours.RandomWalkBehaviour;
import player001.behaviours.gardner.FarmBehaviour;
import player001.fsm.FSM;
import player001.fsm.State;
import player001.predicates.CanPlantTreePredicate;
import player001.predicates.IsDonePredicate;

/**
 * Created by lucas on 13/07/17.
 */
public class Gardner {
    public Gardner(RobotController rc) {
        FSM fsm = new FSM();

        // states
        State randomWalk = new State(new RandomWalkBehaviour(rc));
        State farm = new State(new FarmBehaviour(rc));

        // randomWalk
        randomWalk.when(new CanPlantTreePredicate(rc)).then(farm);

        // plantTree
        farm.when(new IsDonePredicate(farm)).then(randomWalk);

        // push states to fsm
        fsm.pushState(randomWalk);
        fsm.pushState(farm);

        // define starting state
        fsm.startAt(randomWalk);

        // execute
        fsm.execute();
    }
}
