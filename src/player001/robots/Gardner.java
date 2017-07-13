package player001.robots;

import battlecode.common.RobotController;
import player001.behaviours.RandomWalkBehaviour;
import player001.fsm.FSM;
import player001.fsm.State;

/**
 * Created by lucas on 13/07/17.
 */
public class Gardner {
    public Gardner(RobotController rc) {
        FSM fsm = new FSM();

        State randomWalk = new State(new RandomWalkBehaviour(rc));

        fsm.pushState(randomWalk);
        fsm.startAt(randomWalk);

        fsm.execute();
    }
}
