Names: Naijiao Zhang (nz21), Sean Hudson (srh50), Noel Moon (nm142), John Martin (jfm41)

**Internal Visualization**

AnimationScene - getRoot() gets the root of the scene

**External Visualization**

Display - controller for the View. Does the algorithmic work for AnimationScene for rendering onto the canvas. getCanvas() gets the canvas, which is the node that all of the 2D objects are drawn onto. update() steps the simulation into the next generation. reset() resets.

**Internal Configuration**

XMLParser - getCAType() gets the type of simulation, getVariableValues() gets the parameter inputs

**External Configuration**

CellularAutomataFactory - decideAndCreateCA() decides what simulation was input and creates the CellularAutomata object based on the input.

**Internal Simulation**

AnimationRules - createSquareGrid() makes the square grid. graphStats() graphs the graph based on the values that its passed. 

**External Simulation**

HexagonalCell - createBasedOnPosition() creates the cell based on x and y coordinates given. getSide() gets the length of the shapes' side in pixels. setRowAndCol() sets the position of the shape

#SLogo Architecture Design

There will be a terminal that has a text input where the user can put in commands. When the command is input, it is parsed and then checked for syntax errors. Then it is sent to the back-end of the terminal where the meaning of the command is interpreted. The list of possible commands will be kept in a resource bundle. Error checking occurs two fold. There will an initial error check at the front end level for parsing errors and other input based errors. Once data is passed to the backend, there might be error checking for backend logic. 

The commands know how to move certain geometric shapes. Our program should parse the code and then do backend logic to move positions in the console. 
The gui should have two components. The left side is the area in which code is written and the right side is a console that displays what the code written does. Once users have written code in logo on the left, the right side should draw the corresponding shapes/output the logo code. 