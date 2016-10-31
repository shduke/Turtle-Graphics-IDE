package command.utility;

import command.AbstractCommand;

public interface IVariable {

    void setExpression(AbstractCommand value, Variable... parameters);
}
