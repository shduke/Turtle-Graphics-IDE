package command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cursor.Coordinate;
import cursor.Cursor;


public class CommandFactory {
    Map<String, Variable> myVariableMap;
    Cursor myCursor;

    /// Just for Testing
    public static class Node {
        public String myCommandType;
        public String myValue;
        public Node myNext;

        Node (String commandType, String value) {
            myCommandType = commandType;
            myValue = value;
        }

    }

    CommandFactory (Cursor cursor) {
        myCursor = cursor;
        myVariableMap = new HashMap<String, Variable>();

    }

    private Node getNextCommandNode (Node commandNode) {
        commandNode = commandNode.myNext;
        return commandNode;
    }

    public AbstractCommand createCommand (Node commandNode) {
        try {
            Class commandClass = Class.forName(commandNode.myCommandType);

            Field commandField = commandClass.getField("MY_NUMBER_OF_COMMAND_PARAMETERS");
            int commandNumberOfParameters = commandField.getInt(null);

            Class[] classParams = new Class[] { Map.class, List.class, Cursor.class };
            if (commandNode.myCommandType == "command.Constant") {
                classParams = new Class[] { Map.class, List.class};
            } 
            Constructor commandConstructor = commandClass.getDeclaredConstructor(classParams);
            List<Object> initArgsList = new ArrayList<Object>();

            List<Object> initParamList = new ArrayList<Object>();
            initArgsList.add(0, myVariableMap);
            initArgsList.add(1, initParamList);
            if (commandNode.myCommandType == "command.cursor.Forward") {
                initArgsList.add(2, myCursor);
            }
            for (int i = 0; i < commandNumberOfParameters; i++) {
                AbstractCommand commandParameter = createCommand(getNextCommandNode(commandNode));
                if (commandNode.myCommandType == "endMultiLine") {
                    break;
                }
                initParamList.add(commandParameter);
            }
            Object[] initArgs = initArgsList.toArray();

            AbstractCommand command = (AbstractCommand) commandConstructor.newInstance(initArgs);
            if (commandNode.myCommandType == "command.Constant") {
                ((Constant) command).myValue = Double.parseDouble(commandNode.myValue);
            }
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

    public static void main (String[] args) {
        CommandFactory testFactory = new CommandFactory(new Cursor(new Coordinate(0, 0)));
        /*Node node1 = new Node("command.cursor.Forward", "");
        Node node2 = new Node("command.Constant", "10");
        node1.myNext = node2;
        AbstractCommand testCommand = testFactory.createCommand(node1);
        testCommand.execute();*/
        
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
