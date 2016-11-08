package command.factory;

import node.Node;

/**
 * @author Sean Hudson (srh50)
 */
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
