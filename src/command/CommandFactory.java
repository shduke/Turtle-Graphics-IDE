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


public abstract class CommandFactory { //TODO: refactor out list? maybe
    private ResourceBundle myCommandResources;
    //public static final Map<String, Variable> myVariableMap = new HashMap<String, Variable>(); /// TODO: //temporary, will probably remove from abstract class
    private List<Class> myParameterTypes;
    private List<Object> myArguments;
    private List<AbstractCommand> myCommandArguments;
    private Node currentNode;
    private INode nodeIterator;

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
        myParameterTypes = new ArrayList<Class>();
        myArguments = new ArrayList<Object>();
        myCommandArguments = new ArrayList<AbstractCommand>();
        //addValues(myArguments, myCommandArguments);
    }

    public AbstractCommand createCommand (INode node) {
        currentNode = node.current();
        nodeIterator = node;
        try {
            Class commandClass = Class.forName(myCommandResources.getString(currentNode.getType()));

            Class[] classParams = getClassParameters();
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);
            //Forward.class

            Object[] initArgs = getClassArguments(currentNode, commandClass);

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
 
//    private Node getNextCommandNode (Node commandNode) {
//        commandNode = commandNode.getNext(); //TODO - is there a way to set the passed in commandNode reference to now point to this?
//        return commandNode;
//    }
    
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
    
//    protected int getLimit(Node commandNode, Class commandClass) throws NoSuchFieldException, IllegalAccessException {
//        int blah = getNumberOfParameters(commandClass);
//        return blah;
//    }
    
    protected boolean getLoopCondition(Node commandNode, Class commandClass, int index) throws NoSuchFieldException, IllegalAccessException {
        int blah = getNumberOfParameters(commandClass);
        return index < blah;
    }
    
//    protected Object getLoopVariable(int index) {
//        return index;
//    }
//    
//    protected Object getterminator(int index) {
//        return getNumberOfParameters();
//    }
    
    protected void getClassCommandArgument (Node node, Class commandClass) throws NoSuchFieldException, IllegalAccessException { //Need to be able to stream Node. @O getLimit()
        int index = 0;
        //nodeIterator.next();
        while(getLoopCondition(nodeIterator.current(), commandClass, index)) {
            nodeIterator.next();
            if(nodeIterator.current().getType().equals("]")) {
                //nodeIterator.next();
                break;
            }
            myCommandArguments.add(nodeIterator.createCommand());
            index++;
        }

        /*for (int i = 0; i < getLimit(currentNode, commandClass); i++) { //node.stream().limit(numberOfParameters).forEach(CommandFactory::createNextNode)
//            currentNode = getNextCommandNode(currentNode);
//            AbstractCommand commandParameter = currentNode.createCommand();
//            myCommandArguments.add(commandParameter);
              nodeIterator.next();
              myCommandArguments.add(nodeIterator.createCommand());
        }*/
    }
    
//    private void createNextCommand(Node node) {
//        addValues(myArguments, getNextCommandNode(node).createCommand());
//    }
    
    protected void addParameterAndValues(Object ... inputs) {
        Arrays.asList(inputs).stream().forEach(arg -> addClassAndValue(arg.getClass(), arg));
    }
    
    
    private <E> void addValues(List<E> container, E ... values) {
        container.addAll(Arrays.asList(values));
    }
    
    protected void addClassAndValue(Class commandClass, Object value) {
        addValues(myParameterTypes, commandClass);
        addValues(myArguments, value);
    }
    
    private Object[] getClassArguments (Node node, Class commandClass) throws NoSuchFieldException, IllegalAccessException {
        //currentNode = node; //TODO: get rid of classwide reference
        getClassCommandArgument(node, commandClass);
        myArguments.add(myCommandArguments.toArray(new AbstractCommand[myCommandArguments.size()]));
        return myArguments.toArray(new Object[myArguments.size()]);
    }

    
    public static void testFunc(String ... tests) {
        System.out.println(tests.toString());
    }
    public static void main (String[] args) {
          String[] test = {"Hi, ", "Sean"};
          String blah = " blah!";
          testFunc(blah);
          testFunc(test);
          //testFunc(test, blah);
          
//        double angle = -360;
//        double lapAngle = 450;
//        System.out.println(((angle % 360) + 360) % 360);
//        System.out.println(lapAngle % 360);
        
//         Node node1 = new CursorNode("command.cursor.Forward");
//         Node node2 = new ConstantNode("command.utility.Constant");
//         node1.setNext(node2);
//         AbstractCommand command = node1.createCommand();
//         command.execute();

//          ICursor cursor = new CursorManager();
//          Node node1 = new CursorNode("tell", cursor);
//          Node node2 = new BracketNode("multiline");
//          node1.setNext(node2);
//          Node node3 = new CursorNode("forward", cursor);
//          node2.setNext(node3);
//          Node node4 = new ConstantNode("constant", 4);
//          node3.setNext(node4);
//          Node node5 = new BracketNode("]");
//          node4.setNext(node5);
//          Node node6 = new CursorNode("forward", cursor);
//          node5.setNext(node6);
//          Node node7 = new CursorNode("id", cursor);
//          node6.setNext(node7);
//          Node node8 = new BracketNode("]");
//          node7.setNext(node8);
//          INode node = new NodeIterator(node1);
//          AbstractCommand testCommand1 = node.createCommand();
//          System.out.println("\n" + testCommand1.execute());
//          node = new NodeIterator(node6);
//          AbstractCommand testCommand2 = node.createCommand();
//          System.out.println("\n" + testCommand2.execute());
          
          ICursor cursor = new CursorManager();
          Node node1 = new CursorNode("tell", cursor);
          Node node2 = new BracketNode("multiline");
          node1.setNext(node2);
          Node node3 = new ConstantNode("constant", 4);
          node2.setNext(node3);
          Node node4 = new BracketNode("]");
          node3.setNext(node4);
          Node node5 = new CursorNode("forward", cursor);
          node4.setNext(node5);
          Node node6 = new CursorNode("id", cursor);
          node5.setNext(node6);
        INode node = new NodeIterator(node1);
        AbstractCommand testCommand1 = node.createCommand();
        System.out.println("\n" + testCommand1.execute());
        node = new NodeIterator(node5);
        AbstractCommand testCommand2 = node.createCommand();
        System.out.println("\n" + testCommand2.execute());  
          
          
//         ICursor cursor = new Cursor(17);
//         Node node1 = new BracketNode("multiline");
//         Node node2 = new CursorNode("pendownp", cursor);
//         node1.setNext(node2);
//         Node node3 = new CursorNode("forward", cursor);
//         node2.setNext(node3);
//         Node node4 = new OperationNode("pi");
//         node3.setNext(node4);
//         Node node5 = new CursorNode("penup", cursor);
//         node4.setNext(node5);
//         Node node6 = new CursorNode("forward", cursor);
//         node5.setNext(node6);
//         Node node7 = new CursorNode("id", cursor);
//         node6.setNext(node7);
//         Node node8 = new BracketNode("]");
//         node7.setNext(node8);
//         INode node = new NodeIterator(node1);
//         AbstractCommand testCommand = node.createCommand();
//         System.out.println("\n" + testCommand.execute());
//         System.out.println(Math.toDegrees(Math.cos(Math.toRadians(10))));
//         
//          Cursor cursor = new Cursor();
//          Node node1 = new OperationNode("ifelse");
//          Node node2 = new CursorNode("forward", cursor);
//          node1.setNext(node2);
//          Node node3 = new ConstantNode("constant", 0);
//          node2.setNext(node3);
//          Node node4 = new BracketNode("multiline");
//          node3.setNext(node4);
//          Node node5 = new CursorNode("home", cursor);
//          node4.setNext(node5);
//          Node node6 = new CursorNode("forward", cursor);
//          node5.setNext(node6);
//          Node node7 = new ConstantNode("constant", 30);
//          node6.setNext(node7);
//          Node node8 = new BracketNode("]");
//          node7.setNext(node8);
//          Node node9 = new BracketNode("multiline");
//          node8.setNext(node9);
//          Node node10 = new CursorNode("heading", cursor);
//          node9.setNext(node10);
//          Node node11 = new ConstantNode("constant", 72);
//          node10.setNext(node11);
//          Node node12 = new BracketNode("]");
//          node11.setNext(node12);
//          INode node = new NodeIterator(node1);
//          AbstractCommand testCommand = node.createCommand();
//          System.out.println("\n" + testCommand.execute());
          
//        Map<String, IVariable> variableMap = new HashMap<String, IVariable>();
//        Cursor cursor = new Cursor();
//        Node node1 = new ParameterNode("set", variableMap);
//        Node node2 = new VariableNode("variable", ":fd50", variableMap);
//        node1.setNext(node2);
//        Node node3 = new CursorNode("forward", cursor);
//        node2.setNext(node3);
//        Node node4 = new ConstantNode("constant", 50);
//        node3.setNext(node4);
//        Node node5 = new VariableNode("instance", ":fd50", variableMap);
//        node4.setNext(node5);
//        Node node6 = new ParameterNode("set", variableMap);
//        node5.setNext(node6);
//        Node node7 = new VariableNode("variable", ":fd50", variableMap);
//        node6.setNext(node7);
//        Node node8 = new CursorNode("forward", cursor);
//        node7.setNext(node8);
//        Node node9 = new ConstantNode("constant", 30);
//        node8.setNext(node9);
//        Node node10 = new VariableNode("instance", ":fd50", variableMap);
//        node9.setNext(node10); 
//        INode test1 = new NodeIterator(node1);
//        AbstractCommand test1Command = test1.createCommand();
//        System.out.println("\n" + test1Command.execute());
//        INode test2 = new NodeIterator(node5);
//        AbstractCommand test2Command = test2.createCommand();
//        System.out.println("\n" + test2Command.execute());
//        INode test3 = new NodeIterator(node6);
//        AbstractCommand test3Command = test3.createCommand();
//        System.out.println("\n" + test3Command.execute());
//        INode test4 = new NodeIterator(node10);
//        AbstractCommand test4Command = test4.createCommand();
//        System.out.println("\n" + test4Command.execute());
          
//        Map<String, IVariable> variableMap = new HashMap<String, IVariable>();
//        Cursor cursor = new Cursor();
//        Node node1 = new ParameterNode("to", variableMap);
//        Node node2 = new VariableNode("functionvariable", "fdX", variableMap);
//        node1.setNext(node2);
//        Node node3 = new BracketNode("multiline");
//        node2.setNext(node3);
//        Node node4 = new VariableNode("variable", ":dist", variableMap);
//        node3.setNext(node4);
//        Node node5 = new BracketNode("]");
//        node4.setNext(node5);
//        Node node6 = new BracketNode("multiline");
//        node5.setNext(node6);
//        Node node7 = new CursorNode("forward", cursor);
//        node6.setNext(node7);
//        Node node8 = new VariableNode("instance", ":dist", variableMap);
//        node7.setNext(node8);
//        Node node9 = new BracketNode("]");
//        node8.setNext(node9);
//        Node node10 = new VariableNode("functioninstance", "fdX", variableMap);
//        node9.setNext(node10);
//        Node node11 = new ConstantNode("constant", 50);
//        node10.setNext(node11); 
//        INode test1 = new NodeIterator(node1);
//        AbstractCommand test1Command = test1.createCommand();
//        System.out.println("\n" + test1Command.execute());
//        INode test2 = new NodeIterator(node10);
//        AbstractCommand test2Command = test2.createCommand();
//        System.out.println("\n" + test2Command.execute());
        
//          Map<String, IVariable> variableMap = new HashMap<String, IVariable>();
//          Cursor cursor = new Cursor();
//          Node node1 = new ParameterNode("repeat", variableMap);
//          Node node2 = new CursorNode("forward", cursor);
//          node1.setNext(node2);
//          Node node3 = new ConstantNode("constant", 10);
//          node2.setNext(node3);
//          Node node4 = new BracketNode("multiline");
//          node3.setNext(node4);
//          Node node5 = new CursorNode("forward", cursor);
//          node4.setNext(node5);
//          Node node6 = new VariableNode("instance", ":repcount", variableMap);
//          node5.setNext(node6);
//          Node node7 = new BracketNode("]");
//          node6.setNext(node7);
//          Node node8 = new VariableNode("instance", ":dist", variableMap);
//          node7.setNext(node8);
//          Node node9 = new BracketNode("]");
//          node8.setNext(node9);
//          Node node10 = new VariableNode("functioninstance", "fdX", variableMap);
//          node9.setNext(node10);
//          Node node11 = new ConstantNode("constant", 50);
//          node10.setNext(node11); 
//          INode test1 = new NodeIterator(node1);
//          AbstractCommand test1Command = test1.createCommand();
//          System.out.println("\n" + test1Command.execute());
          
//          Map<String, IVariable> variableMap = new HashMap<String, IVariable>();
//          Cursor cursor = new Cursor();
//          Node node1 = new ParameterNode("dotimes", variableMap);
//          
//          Node insert1 = new BracketNode("multiline");
//          node1.setNext(insert1);
//          
//          Node node2 = new VariableNode("variable", ":runthis", variableMap);
//          insert1.setNext(node2);
//          Node node3 = new ConstantNode("constant", 10);
//          node2.setNext(node3);
//          
//          Node insert2 = new BracketNode("]");
//          node3.setNext(insert2);
//          
//          Node node4 = new BracketNode("multiline");
//          insert2.setNext(node4);
//          Node node5 = new CursorNode("forward", cursor);
//          node4.setNext(node5);
//          Node node6 = new VariableNode("instance", ":runthis", variableMap);
//          node5.setNext(node6);
//          Node node7 = new BracketNode("]");
//          node6.setNext(node7);
//          Node node8 = new VariableNode("instance", ":dist", variableMap);
//          node7.setNext(node8);
//          Node node9 = new BracketNode("]");
//          node8.setNext(node9);
//          Node node10 = new VariableNode("functioninstance", "fdX", variableMap);
//          node9.setNext(node10);
//          Node node11 = new ConstantNode("constant", 50);
//          node10.setNext(node11); 
//          INode test1 = new NodeIterator(node1);
//          AbstractCommand test1Command = test1.createCommand();
//          System.out.println("\n" + test1Command.execute());
          
//          Map<String, IVariable> variableMap = new HashMap<String, IVariable>();
//          Cursor cursor = new Cursor();
//          Node node1 = new ParameterNode("for", variableMap);
//          
//          Node insert1 = new BracketNode("multiline");
//          node1.setNext(insert1);
//          
//          Node node2 = new VariableNode("variable", ":runthis", variableMap);
//          insert1.setNext(node2);
//          Node node3 = new ConstantNode("constant", 10);
//          node2.setNext(node3);
//          
//          Node insert3 = new ConstantNode("constant", 27);
//          node3.setNext(insert3);
//          
//          Node insert4 = new ConstantNode("constant", 3);
//          insert3.setNext(insert4);
//          
//          Node insert2 = new BracketNode("]");
//          insert4.setNext(insert2);
//          
//          Node node4 = new BracketNode("multiline");
//          insert2.setNext(node4);
//          Node node5 = new CursorNode("forward", cursor);
//          node4.setNext(node5);
//          Node node6 = new VariableNode("instance", ":runthis", variableMap);
//          node5.setNext(node6);
//          Node node7 = new BracketNode("]");
//          node6.setNext(node7);
//          Node node8 = new VariableNode("instance", ":dist", variableMap);
//          node7.setNext(node8);
//          Node node9 = new BracketNode("]");
//          node8.setNext(node9);
//          Node node10 = new VariableNode("functioninstance", "fdX", variableMap);
//          node9.setNext(node10);
//          Node node11 = new ConstantNode("constant", 50);
//          node10.setNext(node11); 
//          INode test1 = new NodeIterator(node1);
//          AbstractCommand test1Command = test1.createCommand();
//          System.out.println("\n" + test1Command.execute());
          
          
          //INode test2 = new NodeIterator(node10);
          //AbstractCommand test2Command = test2.createCommand();
          //System.out.println("\n" + test2Command.execute());
        
//        INode test3 = new NodeIterator(node6);
//        AbstractCommand test3Command = test3.createCommand();
//        System.out.println("\n" + test3Command.execute());
//        INode test4 = new NodeIterator(node10);
//        AbstractCommand test4Command = test4.createCommand();
//        System.out.println("\n" + test4Command.execute());
          
//        Node node1 = new OperationNode("command.math.Sum");
//        Node node2 = new ConstantNode("command.utility.Constant", 10);
//        Node node3 = new ConstantNode("command.utility.Constant", 20);
//        node1.setNext(node2);
//        node2.setNext(node3);
//        AbstractCommand testCommand = node1.createCommand();
//        System.out.println(testCommand.execute());
    }

}
