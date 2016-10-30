package command.control;

import command.AbstractCommand;

public class IfElse extends AbstractCommand {
    private static final int MY_NUMBER_OF_COMMAND_PARAMETERS = 3;
    
    public IfElse (AbstractCommand... arguments) {
        super(null, arguments);
    }

    @Override
    public double execute () {
        return myArguments.get(0).execute() != 0 ? myArguments.get(1).execute() : myArguments.get(2).execute();
    }

}