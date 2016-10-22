package command;

public class VariableName extends AbstractCommand {
    String myVariableName;

    VariableName (String variableName) {
        myVariableName = variableName;
    }

    @Override
    double execute () {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String toString() {
        return myVariableName;
    }

}
