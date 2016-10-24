package command.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import command.AbstractCommand;

public class MultiLine extends AbstractCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = Integer.MAX_VALUE;
    
    protected MultiLine (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        double value = 0;
        for(AbstractCommand command : getExpression()) {
            value = command.execute();
        }
        return value;
    }

}
