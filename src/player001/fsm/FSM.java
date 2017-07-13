package player001.fsm;

import battlecode.common.Clock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 13/07/17.
 */

/*
 FSM.when(behaviour).given(predicate).then(new_behaviour);
 FSM.link(behaviour, predicate, new_behaviour);
 */

public class FSM {
    private State currentState;
    private List<State> stateList;

    public FSM() {
        this.stateList = new ArrayList<>();
    }

    /**
     * Add a new possible state.
     * @param newState
     */
    public void pushState(State newState) {
        this.stateList.add(newState);
    }

    /**
     * Specify the state to start at.
     * @param startState
     */
    public void startAt(State startState) {
        this.currentState = startState;
    }

    /**
     * Execute the FSM :D
     */
    public void execute() {
        while (true) {
            try {

                // do current behaviours step
                this.currentState.getBehaviour().doStep();

                // do predicate steps
                this.currentState.tickPredicates();

                // check for state transitions
                for (Transition transition : this.currentState.getTransitionsList()) {
                    if (transition.getPredicate().isTrue()) {

                        System.out.println("State transition: from " + this.currentState.getName() + " to " + transition.getNextState().getName());

                        this.currentState = transition.getNextState();
                        this.currentState.init();
                        break;
                    }
                }

                // wait for next step
                System.out.println("Bytecode left is " + Integer.toString(Clock.getBytecodesLeft()));
                Clock.yield();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



