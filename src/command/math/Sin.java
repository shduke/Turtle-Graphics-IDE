package command.math;

import java.util.List;
import java.util.Map;
import command.AbstractCommand;
import command.CalculationCommand;
import command.CursorCommand;
import command.utility.Variable;
import cursor.Cursor;

public class Sin extends CalculationCommand {
    public static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 1;
    
    public Sin (Map<String, Variable> variableMap, List<AbstractCommand> inputs) {
        super(variableMap, inputs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return Math.toDegrees(Math.sin(getFirstCommand().execute()));
    }
    
}