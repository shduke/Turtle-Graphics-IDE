package command;

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
import command.cursor.Forward;
import command.utility.Constant;
import command.utility.MultiLine;
import command.utility.Variable;
import cursor.Coordinate;
import cursor.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import node.ConstantNode;
import node.CursorNode;
import node.Node;
import node.OperationNode;


public abstract class CommandFactory {
    private ResourceBundle myCommandResources;
    public static final Map<String, Variable> myVariableMap = new HashMap<String, Variable>(); /// TODO: //temporary, will probably remove from abstract class
    private List<Class> myParameterTypes;
    private List<Object> myArguments;
    private List<AbstractCommand> myCommandArguments;

    /*
     * public static Cursor testCursor = new Cursor(new Coordinate(0,0));
     * /// Just for Testing
     * public interface Node {
     * AbstractCommand createCommand();
     * Node getNext();
     * void setNext(Node nextNode);
     * String getCommandType();
     * }
     * 
     * public static class CursorNode implements Node{
     * public String myCommandType; //Abstract
     * public Cursor myCursor; //child
     * public Node myNext;
     * 
     * CursorNode (String commandType) {
     * myCommandType = commandType;
     * myCursor = testCursor;
     * }
     * 
     * @Override
     * public AbstractCommand createCommand() {
     * CursorCommandFactory cmf = new CursorCommandFactory(myCursor);
     * return cmf.createCommand(this);
     * }
     * 
     * @Override
     * public Node getNext () {
     * return myNext;
     * }
     * 
     * @Override
     * public void setNext (Node nextNode) {
     * myNext = nextNode;
     * }
     * 
     * @Override
     * public String getCommandType () {
     * return myCommandType;
     * }
     * }
     * public static class ConstantNode implements Node{
     * public String myCommandType; //Abstract
     * public double myValue; //child
     * public Node myNext;
     * 
     * ConstantNode (String commandType) {
     * myCommandType = commandType;
     * myValue = 10;
     * }
     * 
     * @Override
     * public AbstractCommand createCommand() {
     * ConstantCommandFactory cmf = new ConstantCommandFactory(myValue);
     * return cmf.createCommand(this);
     * }
     * 
     * @Override
     * public Node getNext () {
     * return myNext;
     * }
     * 
     * @Override
     * public void setNext (Node nextNode) {
     * myNext = nextNode;
     * }
     * 
     * @Override
     * public String getCommandType () {
     * return myCommandType;
     * }
     * }
     */

    CommandFactory () {
        myCommandResources = ResourceBundle.getBundle("commands");
        myParameterTypes = new ArrayList<Class>(Arrays.asList(List.class));
        myArguments = new ArrayList<Object>();
        myCommandArguments = new ArrayList<AbstractCommand>();
        addArguments(myCommandArguments);
    }

    public AbstractCommand createCommand (Node node) {
        try {
            Class commandClass = Class.forName(myCommandResources.getString(node.getType()));

            Class[] classParams = getClassParameters();
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);
            //Forward.class

            Object[] initArgs = getClassArguments(node, getNumberOfParameters(commandClass));

            AbstractCommand command = (AbstractCommand) commandConstructor.newInstance(initArgs);
            return command;
        }
        //PROBABLY NEED TO CHANGE TO FRONT END???
        catch (ClassNotFoundException e) { //TODO-@ErrorHandlerPerson throw these errors (or a new error class) with a more descriptive message to the controller and have that open an alert view
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("ClassNotFoundException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("NoSuchMethodException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("SecurityException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("NoSuchFieldException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("IllegalArgumentException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("IllegalAccessException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("InstantiationException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error!");
        	alert.setHeaderText("Fatal Error!");
        	alert.setContentText("InvocationTargetException!");
        	alert.showAndWait();
            e.printStackTrace();
        }
        return null;
    }
 
    protected Node getNextCommandNode (Node commandNode) {
        commandNode = commandNode.getNext(); //TODO - is there a way to set the passed in commandNode reference to now point to this?
        return commandNode;
    }
    
    private int getNumberOfParameters (Class commandClass) throws NoSuchFieldException,
                                                           IllegalAccessException {
        Field commandField = commandClass.getDeclaredField("MY_NUMBER_OF_COMMAND_PARAMETERS");
        commandField.setAccessible(true);
        int commandNumberOfParameters = commandField.getInt(null);
        return commandNumberOfParameters;
    }
    
    protected void addParameterTypes (Class ... parameters) {
        myParameterTypes.addAll(Arrays.asList(parameters));
    }

    protected Class[] getClassParameters () {
        return myParameterTypes.toArray(new Class[myParameterTypes.size()]);
    }    
    
    protected void getClassCommandArgument (int numberOfParameters, Node node) { //Need to be able to stream Node
        for (int i = 0; i < numberOfParameters; i++) { //node.stream().limit(numberOfParameters).forEach(CommandFactory::createNextNode)
            node = getNextCommandNode(node);
            AbstractCommand commandParameter = node.createCommand();
            myCommandArguments.add(commandParameter);
        }
    }
    
    private void createNextCommand(Node node) {
        addArguments(getNextCommandNode(node).createCommand());
    }
    
    protected void addArguments (Object ... parameters) {
        myArguments.addAll(Arrays.asList(parameters));
    }

    protected void addCommandArguments (AbstractCommand ... parameters) {
        myCommandArguments.addAll(Arrays.asList(parameters));
    }
    
    private Object[] getClassArguments (Node node, int numberOfParameters) {
        getClassCommandArgument(numberOfParameters, node);
        return myArguments.toArray(new Object[myArguments.size()]);
    }

    public static void main (String[] args) {

//         Node node1 = new CursorNode("command.cursor.Forward");
//         Node node2 = new ConstantNode("command.utility.Constant");
//         node1.setNext(node2);
//         AbstractCommand command = node1.createCommand();
//         command.execute();

         Cursor cursor = new Cursor();
         Node node1 = new CursorNode("forward", cursor);
         Node node2 = new CursorNode("forward", cursor);
         node1.setNext(node2);
         Node node3 = new CursorNode("forward", cursor);
         node2.setNext(node3);
         Node node4 = new ConstantNode("constant", 10);
         node3.setNext(node4);
         AbstractCommand testCommand = node1.createCommand();
         testCommand.execute();

//        Node node1 = new OperationNode("command.math.Sum");
//        Node node2 = new ConstantNode("command.utility.Constant", 10);
//        Node node3 = new ConstantNode("command.utility.Constant", 20);
//        node1.setNext(node2);
//        node2.setNext(node3);
//        AbstractCommand testCommand = node1.createCommand();
//        System.out.println(testCommand.execute());
    }

}
