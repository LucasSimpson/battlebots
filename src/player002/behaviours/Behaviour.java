package player002.behaviours;

import battlecode.common.GameActionException;

/**
 * Created by lucas on 13/07/17.
 */
public interface Behaviour {
    void init();
    void doStep() throws GameActionException;
    boolean isDone();

    String getName();
}
