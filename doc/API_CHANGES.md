## API Changes

**Front-end External API**

* ISlogoWindowView (interface)
 * getHistory()
 * getScene()
 * getTurtleDisplay()
 * setHistoryBinding()
* IHistory (interface)
 * getRecentCommand()
 * getAllCommands()
* IVariablesAndCommands (interface)
 * addVariable()
 * addCommand()
 * addResults()
* Display (interface)
 * redrawAll();
 * setBackgroundColor();
 * setPenColor();
 * getStackPane();
 * setTurtleImage();


One change that was made to the front-end external API was adding a method to set a binding to the history of the GUI. This was done so that the controller could call that method to bind the history. Another change was adding a method called redrawAll() to get the turtle display so that the controller could then call another method on that turtle display to update what is going on in the turtle display. In the history class, there is a getRecentCommand() that is used by the controller to get the most recent command that was input.

**Front-end Internal API**

* ISlogoWindowView (interface)
 * getAppWidth()
 * getAppHeight()
 * IHistory (interface)
 * setBinding()
 * clear()
 * getTextArea()
 * addHistory()
* IVariablesAndCommands (interface)
 * clear()
 * getTextArea()
 * updateTextArea()
* IToolbar (interface)
 * getToolbar()
* IInputField (interface)
 * getInputField()
* TurtleDisplay
 * getStackPane()

We added clear() methods to the IHistory and IVariablesAndCommands interfaces in order to be able to implement the event where the user presses the reset button on the toolbar. We also added getTextArea() for those two interfaces in order to provide a method to access the textAreas that are for the history and variables/commands. A setBinding() method was added to the IHistory interface to implement the setHistoryBinding() method in the external front-end API.

**Back-end External API**

* IDrawable (Interface)
 * List<ICoordinate>getCoordinates()
 * Int getLayer()
 * Int getOrientation()
 * Boolean getIsVisible()
* ICoordinate
 * double getX()
 * double getY()
* ExpressionTree
 * HashMap getMap()
 * add()

We changed the back end external API to pass out interfaces instead of class objects. By doing it this way we are able to better encapsulate the data and methods of the backend classes, so that the front end won't have access to them. Before we were just passing up the entire Cursor class which was simpler, but a worse design. If the front end requires more methods from the backend then we will have to add that to their respective API and thus require the backend classes to implement those methods

**Back-end Internal API**

* CommandFactory
 * AbstractCommand createCommand()
* AbstractCommand
 * List getExpression
* Node
 * createCommand()
* ExpressionTree
 * createCommand()

We changed the backend internal API to follow a factory pattern instead of what we originally envisioned. We had originally planned to parse the user input, create and expression tree, and then have the backend traverse the expression tree to make the necessary commands. However, we found that difficult to implement because we could not uniformly create the correct commands from a generic node. Each node needed to create a specific type of command specific to that node, and it was very difficult without involving a lot of instanceOf to create the command without utilizing a factory pattern and having the nodes create themselves. 