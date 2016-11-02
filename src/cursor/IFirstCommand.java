package cursor;

import java.util.List;
import command.ICommand;

public interface IFirstCommand {
    double execute();
    List<ICommand> getInnerCommands();
}
