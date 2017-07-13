package player001.fsm;

import player001.behaviours.Behaviour;
import player001.predicates.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 13/07/17.
 */
public class State {
    private Behaviour behaviour;
    private List<Transition> transitionsList;

    public State(Behaviour behaviour) {
        this.behaviour = behaviour;
        this.transitionsList = new ArrayList<>();
    }

    public void init() {
        System.out.println("Entering State " + this.getName());

        this.behaviour.init();
        for (Transition transition: this.transitionsList) {
            transition.getPredicate().init();
        }
    }

    public void tickPredicates() {
        for (Transition transition: this.transitionsList) {
            transition.getPredicate().tick();
        }
    }

    public void pushTransition(Predicate predicate, State nextState) {
        this.transitionsList.add(new Transition(predicate, nextState));
    }

    public List<Transition> getTransitionsList() {
        return this.transitionsList;
    }

    public Behaviour getBehaviour() {
        return this.behaviour;
    }

    public String getName() {
        return this.behaviour.getName();
    }

    public PartialTransition when(Predicate predicate) {
        return new PartialTransition(this, predicate);
    }

    public class PartialTransition {
        private State homeState;
        private Predicate predicate;

        PartialTransition(State homeState, Predicate predicate) {
            this.homeState = homeState;
            this.predicate = predicate;
        }

        public void then(State newState) {
            this.homeState.pushTransition(this.predicate, newState);
        }
    }
}
