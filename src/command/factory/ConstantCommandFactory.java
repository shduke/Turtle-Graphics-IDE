package command.factory;

/**
 * @author Sean Hudson (srh50)
 */
public class ConstantCommandFactory extends CommandFactory {
    private double myValue;

    public ConstantCommandFactory (double value) {
        super();
        myValue = value;
        addParameterAndValues(myValue);
    }

}
