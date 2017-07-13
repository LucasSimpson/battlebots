package player001.predicates;

import player001.behaviours.Behaviour;
import player001.fsm.State;

/**
 * Created by lucas on 13/07/17.
 */
public class IsDonePredicate implements Predicate {
    private Behaviour behaviour;

    public IsDonePredicate(State stateBehaviour) {
        this.behaviour = stateBehaviour.getBehaviour();
    }

    public void init() {}

    public boolean isTrue() {
        return this.behaviour.isDone();
    }

    public void tick() {}
}
