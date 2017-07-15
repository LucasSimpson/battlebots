package player002.predicates;

/**
 * Created by lucas on 13/07/17.
 */
public interface Predicate {
    void init();
    void tick();
    boolean isTrue();
}
