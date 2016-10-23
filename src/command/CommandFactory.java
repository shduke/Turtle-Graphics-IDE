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
    public static Cursor testCursor = new Cursor(new Coordinate(0,0));
    /// Just for Testing
    public interface Node {
        AbstractCommand createCommand();
        Node getNext();
        void setNext(Node nextNode);
        String getCommandType();
    }
    
    public static class CursorNode implements Node{
        public String myCommandType; //Abstract
        public Cursor myCursor; //child
        public Node myNext;

        CursorNode (String commandType) {
            myCommandType = commandType;
            myCursor = testCursor;
        }
        @Override
        public AbstractCommand createCommand() {
            CursorCommandFactory cmf = new CursorCommandFactory(myCursor);
            return cmf.createCommand(this);
        }

        @Override
        public Node getNext () {
            return myNext;
        }
        @Override
        public void setNext (Node nextNode) {
            myNext = nextNode;
        }
        @Override
        public String getCommandType () {
            return myCommandType;
        }
    }
    public static class ConstantNode implements Node{
        public String myCommandType; //Abstract
        public double myValue; //child
        public Node myNext;

        ConstantNode (String commandType) {
            myCommandType = commandType;
            myValue = 10;
        }
        @Override
        public AbstractCommand createCommand() {
            ConstantCommandFactory cmf = new ConstantCommandFactory(myValue);
            return cmf.createCommand(this);
        }

        @Override
        public Node getNext () {
            return myNext;
        }
        @Override
        public void setNext (Node nextNode) {
            myNext = nextNode;
        }
        @Override
        public String getCommandType () {
            return myCommandType;
        }
    }
    

    CommandFactory () {

    }

    protected Node getNextCommandNode (Node commandNode) {
        commandNode = commandNode.getNext();
        return commandNode;
    }

    public AbstractCommand createCommand (Node node) {
        try {
            Class commandClass = Class.forName(node.getCommandType());

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
        parameters.add(Map.class);
        parameters.add(List.class);
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

//        Node node1 = new CursorNode("command.cursor.Forward");
//        Node node2 = new ConstantNode("command.utility.Constant");
//        node1.setNext(node2);
//        AbstractCommand command = node1.createCommand();
//        command.execute();
        
        Node node1 = new CursorNode("command.cursor.Forward");
        Node node2 = new CursorNode("command.cursor.Forward");
        node1.setNext(node2);
        Node node3 = new CursorNode("command.cursor.Forward");
        node2.setNext(node3);
        Node node4 = new ConstantNode("command.utility.Constant");
        node3.setNext(node4);
        AbstractCommand testCommand = node1.createCommand();
        testCommand.execute();
        
    }

}
