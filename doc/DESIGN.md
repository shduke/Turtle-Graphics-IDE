DESIGN.md
==========
---
![Image](images/slogo.PNG)

Introduction
---

We are making a program where a user can input commands into a command line, and then a turtle moves or does other actions in response to those commands. The primary design goal is to be able to have the program respond to a variety of commands and to easily be able to implement more commands. Another goal of flexibility is to be able to have an object other than a turtle that is responding to the user commands. The View part of the program will take care of showing the turtle and the terminal. It will also take care of making the turtle move in response to the user input. The Model part of the program will take care of invalid user input and interpreting the user input into something that can be understood by the View. The Controller will integrate the Model and View by passing the front-end’s user input to the back-end. After the back-end has parsed the input, it will pass the interpreted input to the Controller, where it will be passed to the View.

Design Overview
---
![Image](images/workflow.PNG)

Front-End Internal API: This API will have Toolbar, History, InputBar, and Canvas classes. These classes will make up the GUI that has the turtle and the terminal. The History will hold all of the commands that the user previously typed. The InputBar will be where the user can input commands. The Canvas will be where the turtle will respond to the user commands.

Front-End External API: This API will have the Display class which will be extended by the Toolbar, History, InputBar, etc. The Display class will display its object on the GUI.

Back-End Internal API: There will be a Unit superclass that will be extended by TurtleUnit, StarUnit, and any other shape that has to be represented. The Unit will keep track of the coordinates on the unit while it is moving around. It will also keep track of other variables like color and direction. 

Back-End External API: There will be a CommandModel that has the parser, which interprets the user input and puts it in a data form that can be understood by the View. The CommandModel will also have the CommandTree, which will keep track of the commands that the user has made and will be able to be traversed through to respond to these commands. It will have a public method caled updateTree() that will update the CommandTree in response to new commands.

User Interface
---
![Image](images/userinterface.PNG)

The user interface will essentially be split into four sections, as seen: the toolbar (allowing for various button and interaction controls), the command history (to keep track of previous input), graphic canvas/display (where the graphic elements will be shown) and the input bar (where commands will be entered).

These elements will be separate classes controlled by the Application Scene. The input bar will be used to enter commands which will then be passed by the Application Scene for passing, at which point they will be verified and computed, taking effect in the Graphic Display before registering in the command history. The toolbar is a separate entity that will enable quick interaction with the application to adjust parameters or for quick buttons such as “save” or “load” functions.

API Details
---
The API details of the project will essentially be divided into two parts -- front end API and back end API. 

The front end external API is used so that the controller can pass a data structure to the view for the view to display objects on the screen as well as the ability for the view to pass information to the controller. In addition, it will have the ability to obtain errors thrown by the backend that is caused by incorrect commands into the command text field. An interface will be implemented to ensure that both the front and and back end contain the necessary methods to both pass lists of objects needed to be rendered upwards from backend to frontend, to throw any errors upwards to the view to create a dialog popup or syntax highlight, and to have a standardized way of passing text field information to the controller. Extensibility of the front end external api includes adding the ability to read additional fields or information, different types of information, and allowing the receival of more complex backend code. 

The front end internal API includes the ability to watch an observables and then, when an event occurs, trigger an event that will make calls to the controller to start grabbing the command string. This bind is important as it allows implementation of the project without utilizing a game loop. In addition, front end internal API includes all of the toolbar methods, history, and canvas methods that must be called to display things on the screen. This includes a method render() that takes the held data structure of objects and then renders it on the canvas, factories for creating GUI components, and factories for changing color and history. Extensibility of the front end internal api includes the ability to add additional GUI components, as well adding additional features that gets triggered when a command is entered. 

The backend external api is linked to an interface, movement, that will move an image left,right, up, down, or rotate. This is important as it provides a contract of sorts for all backend models that represent different shapes, effectively stating that the view will be able to render the backend model so long as it has those given methods that move an image left, right, up, down. In addition, there will be a command class that stores the values of certain commands and then has external apis to be called to tell an image where to translate. For example, fd 50 may shift the decrease the y value of an image. Finally, there will be a factory system to create different shapes that must be rendered by the view. Extensibility of the backend external api includes shifting the image in different ways other than the traditional left, right, up, down, and rotate. 

The backend internal api includes all of the methods that move images internally such as moveUp(), moveDown(), moveLeft(), etc. There will be methods to decipher commands given from an expression tree and then to call corresponding internal APIs to appropriately shift an image. There will also be methods to reset values and to restart and put images back into their original locations. The backend internal api can be extended by incorporating different features to correspond with commands or to add additional error messages that might be thrown upwards. 

API Example Code
---
‘fd 50’
As soon as the user presses enter, the input bar will be observed and the user input will be interpreted by the parser with a parseString() method. After it has been parsed, the parsed data will be passed to the controller where it will be passed to the History and the Canvas. History will call addHistory() to add this command to the history, and Canvas will call updateCanvas() to move the turtle in response to the command.

Design Considerations
---
There are a couple more design features that we need to iron out before attempting a complete design solution. We need to refine our observer-observable pattern. We need to pinpoint precisely which instance variables we are going to make observable as well as which objects or events are going to observe them. This will not change the flow of the program that much since this pattern will just provide a cleaner way for our MVC components to interact.

In discussing our design for the project we came across a few design decisions. The first one was with regards to the MVC layout of the program. We initially planned for Main to create an instance of the GUI, which would then create the controller for handling connections between the display and the model. This, however, did not make that much sense, since we were having the GUI create and hold a reference to the controller rather than the other way around. We decided to have Main create an instance of an ApplicationController that would hold the references that make up the GUI as well as the model. By laying it out in this way we were able to main the MVC format of the controllers controlling the views and models. Another MVC related aspect that we discussed was whether to include the command parser in the controller or not. By having it in the controller we would be able to immediately parse the command and handle any exceptions and then ultimately pass the parsed data into the backend to be processed into a tree. We concluded that this would not be the optimal way of going about it since we are fragmenting our model. The parser is really a backend model type feature. Thus we decided to add a method to our external API for the backend that would take in the command string and would be called by the CommandController. The parser would throw any exceptions it caught from bad input up to the controller to handle. By doing it this way we are able to maintain the MVC design of having all of the program logic contained within the model.

Another design feature that we discussed was how to give the view access to the model’s data so it could display it. We initially thought it would be a good idea to pass the graphics context of the canvas down into each of the Turtles and have them render themselves. This would put the rendering responsibility on each individual turtle so we would not have to worry about it collectively. We decided not to go with this approach because this method resulted in mixing the view and model roles. The model should be independent from the view in that it should not know how it is being displayed. We decided to pass up the information from the model through an external API call. The frontend will use the back end’s external API call to view that data it needs in order to render the images. By doing it this way, we can avoid having any javaFX imports in our model, which means that we can achieve a much greater separation between our frontend and backend.

Team Responsibilities
---

Front End Team: John Martin, Noel Moon

Back End Team: Sean Hudson, Naijiao Zhang

The two teams will maintain close communication within the teams to create a functional front-end/back-end, and then the two teams will come together to integrate the controller with the model and the view to create a fully functional program.

Within each team, one member will be fully committed to their area, and the other will work mostly on their area but also looking towards integration (working with the other teams integration member to ensure a fully functioning design). These roles have yet to be fully finalised.
