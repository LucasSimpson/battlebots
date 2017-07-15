package player002.fsm;

import player002.predicates.Predicate;

/**
 * Created by lucas on 13/07/17.
 */
public class Transition {
    private Predicate predicate;
    private State nextState;

    public Transition(Predicate predicate, State nextState) {
        this.predicate = predicate;
        this.nextState = nextState;
    }

    Predicate getPredicate() {
        return this.predicate;
    }

    State getNextState() {
        return this.nextState;
    }
}
