package player001.predicates;

/**
 * Created by lucas on 13/07/17.
 */
public class TimedPredicate implements Predicate {
    private int totalTicks, ticksLeft;

    public TimedPredicate(int totalTicks) {
        this.totalTicks = totalTicks;
    }

    public void init() {
        this.ticksLeft = this.totalTicks;
    }

    public void tick() {
        this.ticksLeft -= 1;
    }

    public boolean isTrue() {
        System.out.println("Timer is " + Integer.toString(this.ticksLeft));
        return this.ticksLeft <= 0;
    }
}
