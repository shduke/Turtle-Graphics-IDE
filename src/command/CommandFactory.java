package command;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Stream;
import com.sun.org.apache.xpath.internal.Arg;
import command.cursor.Forward;
import command.utility.Constant;
import command.utility.IVariable;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.Cursor;
import cursor.CursorManager;
import cursor.ICursor;
import exception.SyntaxException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import node.BracketNode;
import node.ConstantNode;
import node.CursorNode;
import node.INode;
import node.Node;
import node.NodeIterator;
import node.OperationNode;
import node.ParameterNode;
import node.VariableNode;


public abstract class CommandFactory {
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

    public AbstractCommand createCommand (INode node) throws SyntaxException {
        currentNode = node.current();
        nodeIterator = node;
        try {
            Class commandClass = Class.forName(myCommandResources.getString(currentNode.getType()));

            Class[] classParams = getClassParameters();
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);
            // Forward.class

            Object[] initArgs = getClassArguments(currentNode, commandClass);

            AbstractCommand command = (AbstractCommand) commandConstructor.newInstance(initArgs);
            return command;
        }
        catch (ClassNotFoundException e) {
            throw new SyntaxException(e);
        }
        catch (NoSuchMethodException e) {
            throw new SyntaxException(e);
        }
        catch (SecurityException e) {
            throw new SyntaxException(e);
        }
        catch (NoSuchFieldException e) {
            throw new SyntaxException(e);
        }
        catch (IllegalArgumentException e) {
            throw new SyntaxException(e);
        }
        catch (IllegalAccessException e) {
            throw new SyntaxException(e);
        }
        catch (InstantiationException e) {
            throw new SyntaxException(e);
        }
        catch (InvocationTargetException e) {
            throw new SyntaxException(e);
        }
    }

    protected int getNumberOfParameters (Class commandClass) throws NoSuchFieldException,
                                                             IllegalAccessException {
        Field commandField = commandClass.getDeclaredField("MY_NUMBER_OF_COMMAND_PARAMETERS");
        commandField.setAccessible(true);
        return commandField.getInt(null);
    }

    protected Class[] getClassParameters () {
        myParameterTypes.add(AbstractCommand[].class);
        return myParameterTypes.toArray(new Class[myParameterTypes.size()]);
    }

    protected boolean getLoopCondition (Node commandNode,
                                        Class commandClass,
                                        int index) throws NoSuchFieldException,
                                                   IllegalAccessException {
        int blah = getNumberOfParameters(commandClass);
        return index < blah;
    }

    protected void getClassCommandArgument (Node node, Class commandClass)
                                                                           throws NoSuchFieldException,
                                                                           IllegalAccessException,
                                                                           SyntaxException { // Need
                                                                                             // to
                                                                                             // be
                                                                                             // able
                                                                                             // to
                                                                                             // stream
                                                                                             // Node.
                                                                                             // @O
                                                                                             // getLimit()
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

    protected void addParameterAndValues (Object ... inputs) {
        Arrays.asList(inputs).stream().forEach(arg -> addClassAndValue(arg.getClass(), arg));
    }

    private <E> void addValues (List<E> container, E ... values) {
        container.addAll(Arrays.asList(values));
    }

    protected void addClassAndValue (Class commandClass, Object value) {
        addValues(myParameterTypes, commandClass);
        addValues(myArguments, value);
    }

    private Object[] getClassArguments (Node node, Class commandClass) throws NoSuchFieldException,
                                                                       IllegalAccessException,
                                                                       SyntaxException {
        getClassCommandArgument(node, commandClass);
        myArguments.add(myCommandArguments.toArray(new AbstractCommand[myCommandArguments.size()]));
        return myArguments.toArray(new Object[myArguments.size()]);
    }

}
