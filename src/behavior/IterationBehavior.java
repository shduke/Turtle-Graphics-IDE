package behavior;

import java.util.Map;
import java.util.stream.IntStream;
import command.AbstractCommand;
import command.utility.IVariable;


public abstract class IterationBehavior extends AbstractCommandBehavior {

    IterationBehavior (AbstractCommand ... arguments) {
        super(arguments);
    }

    @Override
    public double executeCommand () {
        double index = getStart();
        while(index < getStop()) {
            assignVariable(index);
            loopBody(index);
            index += getIncrement();
        }
        return getResult();
        
//      IntStream.range(getStart(), getStop())
//      .map(a -> a - getStart())
//      .filter(a -> a % getIncrement() == 0)
//      .map(a -> a + getStart()).forEach(a -> {
//          assignVariable(a);
//          loopBody(a);
//      });
//;
    }

    protected abstract double getStart ();

    protected abstract double getStop ();

    protected abstract double getIncrement ();

    protected abstract void assignVariable (double index);

    protected abstract void loopBody (double index);
    
    protected abstract double getResult ();
 
}
