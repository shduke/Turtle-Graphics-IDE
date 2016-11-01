package command.utility;

import command.AbstractCommand;

public interface IVariable {

    void setExpression(AbstractCommand value, IVariable... myParameters);
    
    double execute();

    void updateParameterValues (int index, AbstractCommand abstractCommand);
    
    int getNumberOfParameters();
}
