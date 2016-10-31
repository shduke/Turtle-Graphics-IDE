package behavior.binary;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import command.AbstractCommand;
import command.utility.Variable;

public class VariableInitializationBehavior extends BinaryBehavior<String, Variable, Variable> {
    private static final int EXPRESSION_KEY_INDEX = 0;    
    
    public VariableInitializationBehavior(BiFunction<String, Variable, Variable> operation, AbstractCommand... arguments) {
        super(operation, arguments);
    }

    @Override
    protected <R> String getInput1 () {
        return getArgument(EXPRESSION_KEY_INDEX).toString();
    }

    @Override
    protected <R> Variable getInput2 () {
        //new Variable(getArgument(EXPRESSION_KEY_INDEX).toString()); // TODO Null command
        return null;
    }
    
    @Override
    protected double evaluateToDouble (Variable result) {
        return 0;
    }


}