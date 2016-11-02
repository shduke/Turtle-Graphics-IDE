package behavior;

import command.AbstractCommand;


public abstract class IterationBehavior extends AbstractCommandBehavior {

    IterationBehavior (AbstractCommand ... arguments) {
        super(arguments);
    }

    @Override
    public double executeCommand () {
        double index = getStart();
        while (index < getStop()) {
            assignVariable(index);
            loopBody(index);
            index += getIncrement();
        }
        return getResult();
    }

    protected abstract double getStart ();

    protected abstract double getStop ();

    protected abstract double getIncrement ();

    protected abstract void assignVariable (double index);

    protected abstract void loopBody (double index);

    protected abstract double getResult ();

}
