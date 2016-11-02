package command;

import java.util.List;

public interface IFirstCommand {
    double execute();
    List<ICommand> getInnerCommands();
}
