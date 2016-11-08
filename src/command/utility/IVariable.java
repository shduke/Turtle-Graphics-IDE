package command.utility;

import command.AbstractCommand;

/**
 * @author Sean Hudson (srh50)
 */
public interface IVariable {

    /**
     * Sets the variable's value
     * @param value
     * @param myParameters
     */
    void setExpression (AbstractCommand value, IVariable ... myParameters);

    /**
     * Executes the expression stored in the variable
     * @return
     */
    double execute ();

    /**
     * Updates the command at an index
     * @param index
     * @param abstractCommand
     */
    void updateParameterValues (int index, AbstractCommand abstractCommand);

    /**
     * Gets number of parameters for the variable
     * @return
     */
    int getNumberOfParameters ();

    /**
     * Gets the last execution value
     * @return
     */
    Double getLastResult ();

    /**
     * sets the value of the last result
     * @param lastResult
     */
    void setlastResult (double lastResult);
}
