package behavior;

/**
 * @author Sean Hudson (srh50)
 */
public class RunnableBehavior extends AbstractCommandBehavior {
    Runnable myOperation;

    public RunnableBehavior (Runnable operation) {
        myOperation = operation;
    }

    @Override
    public double executeCommand () {
        myOperation.run();
        return 0;
    }
}
