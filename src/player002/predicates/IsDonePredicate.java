package player002.predicates;

import player002.behaviours.Behaviour;
import player002.fsm.State;

/**
 * Created by lucas on 13/07/17.
 */
public class IsDonePredicate implements Predicate {
    private final Behaviour behaviour;

    public IsDonePredicate(State stateBehaviour) {
        this.behaviour = stateBehaviour.getBehaviour();
    }

    public void init() {}

    public boolean isTrue() {
        return this.behaviour.isDone();
    }

    public void tick() {}
}
