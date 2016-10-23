package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import command.CommandFactory.Node;
import command.utility.Constant;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.Cursor;


public abstract class CommandFactory {
    public static final Map<String, Variable> myVariableMap = new HashMap<String, Variable>(); ///TODO: Refactor this, temporary just until we figure out the factory structure more (maybe create a headNode or an ExpressionFactory)
    
    /// Just for Testing
    public static class Node {
        public String myCommandType; //Abstract
        public String myValue; //child
        public Node myNext;

        Node (String commandType, String value) {
            myCommandType = commandType;
            myValue = value;
        }

    }

    CommandFactory () {

    }

    protected Node getNextCommandNode (Node commandNode) {
        commandNode = commandNode.myNext;
        return commandNode;
    }

    public AbstractCommand createCommand (Node node) {
        try {
            Class commandClass = Class.forName(node.myCommandType);

            Class[] classParams = getClassParameters();
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);

            Object[] initArgs = getClassArguments(node, getNumberOfParameters(commandClass));

            AbstractCommand command = (AbstractCommand) commandConstructor.newInstance(initArgs);
            //List<MultiLine> commndList = new ArrayList();
            //MultiLine newCommand = new MultiLine(myVariableMap, command);
            //gueue it up
            return command;
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private int getNumberOfParameters (Class commandClass) throws NoSuchFieldException,
                                                           IllegalAccessException {
        Field commandField = commandClass.getField("MY_NUMBER_OF_COMMAND_PARAMETERS");
        int commandNumberOfParameters = commandField.getInt(null);
        return commandNumberOfParameters;
    }

    protected abstract List<Class> getClassSpecificParameters();
    
    protected Class[] getClassParameters() {
        List<Class> parameters = new ArrayList<Class>();
        parameters.addAll(getClassSpecificParameters());
        return parameters.toArray(new Class[parameters.size()]);
    }
    
    protected abstract List<Object> getClassSpecificArguments();
    
    protected abstract List<Object> getClassCommandArgument(int numberOfParameters, Node node);
    
    /*private MultiLine getInputCommand(int numberOfParameters, Node node) {
        List<Object> initParamList = new ArrayList<Object>();
        initParamList.add(myVariableMap);
        for (int i = 0; i < numberOfParameters; i++) {
            MultiLine commandParameter = createCommand(getNextCommandNode(node));
            if (node.myCommandType == "endMultiLine") {
                break;
            }
            initParamList.add(commandParameter);
        }
    }*/
    
    
    private Object[] getClassArguments(Node node, int numberOfParameters) {
        List<Object> arguments = new ArrayList<Object>();
        arguments.add(myVariableMap);
        arguments.add(getClassCommandArgument(numberOfParameters, node));
        arguments.addAll(getClassSpecificArguments());
        return arguments.toArray(new Object[arguments.size()]);
    }
    
    
    public static void main (String[] args) {
        CommandFactory testCursorFactory = new CursorCommandFactory(new Cursor(new Coordinate(0, 0)));
        CommandFactory testConstantFactory = new ConstantCommandFactory(4);
        Node node1 = new Node("command.cursor.Forward", "");
        Node node2 = new Node("command.Constant", "10");
        node1.myNext = node2;
        AbstractCommand testCommand = testFactory.createCommand(node1);
        testCommand.execute();
        
        Node node1 = new Node("command.cursor.Forward", "");
        Node node2 = new Node("command.cursor.Forward", "");
        node1.myNext = node2;
        Node node3 = new Node("command.cursor.Forward", "");
        node2.myNext = node3;
        Node node4 = new Node("command.Constant", "10");
        node3.myNext = node4;
        AbstractCommand testCommand = testFactory.createCommand(node1);
        testCommand.execute();
        
    }

}
