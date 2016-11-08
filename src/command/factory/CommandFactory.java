package command.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import command.AbstractCommand;
import exception.SyntaxException;
import node.INode;
import node.Node;

/**
 * @author Sean Hudson (srh50)
 */
public abstract class CommandFactory implements ICommandFactory{
    private ResourceBundle myCommandResources;
    private List<Class> myParameterTypes;
    private List<Object> myArguments;
    private List<AbstractCommand> myCommandArguments;
    private Node currentNode;
    private INode nodeIterator;

    CommandFactory () {
        myCommandResources = ResourceBundle.getBundle("commands");
        myParameterTypes = new ArrayList<Class>();
        myArguments = new ArrayList<Object>();
        myCommandArguments = new ArrayList<AbstractCommand>();
    }

    /**
     * Creates the command
     */
    public AbstractCommand createCommand (INode node) throws SyntaxException {
        currentNode = node.current();
        nodeIterator = node;
        try {
            Class commandClass = Class.forName(myCommandResources.getString(currentNode.getType()));

            Class[] classParams = getClassParameters();
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);

            Object[] initArgs = getClassArguments(currentNode, commandClass);

            AbstractCommand command = (AbstractCommand) commandConstructor.newInstance(initArgs);
            return command;
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new SyntaxException(e);
        }
    }

    /**
     * Gets the number of parameters
     * @param commandClass
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected int getNumberOfParameters (Class commandClass) throws NoSuchFieldException,
                                                             IllegalAccessException {
        Field commandField = commandClass.getDeclaredField("MY_NUMBER_OF_COMMAND_PARAMETERS");
        commandField.setAccessible(true);
        return commandField.getInt(null);
    }

    /**
     * Gets the Classes of the parameters
     * @return
     */
    protected Class[] getClassParameters () {
        myParameterTypes.add(AbstractCommand[].class);
        return myParameterTypes.toArray(new Class[myParameterTypes.size()]);
    }

    /**
     * Gets the loop terminating condition
     * @param commandNode
     * @param commandClass
     * @param index
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected boolean getLoopCondition (Node commandNode,
                                        Class commandClass,
                                        int index) throws NoSuchFieldException,
                                                   IllegalAccessException {
        int blah = getNumberOfParameters(commandClass);
        return index < blah;
    }

    /**
     * Gets the command arguments for a command
     * @param node
     * @param commandClass
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws SyntaxException
     */
    protected void getClassCommandArgument (Node node, Class commandClass)
                                                                           throws NoSuchFieldException,
                                                                           IllegalAccessException,
                                                                           SyntaxException {
        int index = 0;
        while (getLoopCondition(nodeIterator.current(), commandClass, index)) {
            nodeIterator.next();
            if (nodeIterator.current().getType().equals("]")) {
                break;
            }
            try {
                myCommandArguments.add(nodeIterator.createCommand());
            }
            catch (SyntaxException e) {
                throw e;
            }
            index++;
        }

    }

    /**
     * Adds a parameter and its class value
     * @param inputs
     */
    protected void addParameterAndValues (Object ... inputs) {
        Arrays.asList(inputs).stream().forEach(arg -> addClassAndValue(arg.getClass(), arg));
    }

    /**
     * Adds values to the different initialization lists
     * @param container
     * @param values
     */
    private <E> void addValues (List<E> container, E ... values) {
        container.addAll(Arrays.asList(values));
    }

    /**
     * Adds a class and its corresponding value to the initialization lists
     * @param commandClass
     * @param value
     */
    protected void addClassAndValue (Class commandClass, Object value) {
        addValues(myParameterTypes, commandClass);
        addValues(myArguments, value);
    }

    /**
     * Gets the class specific arguments
     * @param node
     * @param commandClass
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws SyntaxException
     */
    private Object[] getClassArguments (Node node, Class commandClass) throws NoSuchFieldException,
                                                                       IllegalAccessException,
                                                                       SyntaxException {
        getClassCommandArgument(node, commandClass);
        myArguments.add(myCommandArguments.toArray(new AbstractCommand[myCommandArguments.size()]));
        return myArguments.toArray(new Object[myArguments.size()]);
    }

}
