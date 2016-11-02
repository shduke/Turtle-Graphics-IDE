package command;

import node.Node;


public class MultiLineCommandFactory extends CommandFactory {
    private static final String MULTILINE_TERMINATOR = "]";

    public MultiLineCommandFactory () {
        super();
    }

    @Override
    protected boolean getLoopCondition (Node commandNode,
                                        Class commandClass,
                                        int index) throws NoSuchFieldException,
                                                   IllegalAccessException {
        return true;
    }
}
