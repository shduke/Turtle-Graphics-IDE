CompSci 308: SLogo API Frontend Review 
===================
Naijiao Zhang (nz21), Harshil Garg (hg75)

> This is the link to the assignment: [API Review](https://www.cs.duke.edu/courses/compsci308/fall16/classwork/07_apireview/)

Part 1
=======
---
What about your API is intended to be flexible: The ability to parse varying commands on the left side of the screen and pass it to the controller. The controller will be flexible enough to create nodes of different commands and still form a expression tree structure. The view should render based on generic code such that changed backend data that is passed up will still be rendered. Connecting a different backend such as IOS Swift Java Api should still be able to be rendered on the frontend. 

How is your API/design encapsulating your implementation decisions: The workflow will be a top-down approach where information goes like this View -> Parser -> Controller to make expression tree -> Backend -> View. Each layer will only know about itself so that adding additional features will not affect the overall design. 

What exceptions might occur: If syntax is incorrect, exceptions might be thrown such that the view will highlight the incorrect commands. In addition, errors might be thrown when the backend cannot set things in the correct location/render at certain locations. 

Why do you think your API design is good: It follows a top down approach that isolates the varying aspects of the assignment. The view only knows that it has to render something, the controller creates an expression tree that is passed into the backend, and the backend does logic to set images at certain locations. Everything is encapsulated and adding additional features will not affect the frontend/backend/ where ever the feature is not implemented. 

Part 2
=======
---
Come up with at least five use cases for your part: 1. Incorrect syntax should highlight red in the view. 2. Typing commands should appropriately render things on the display to show where things end up. 3. There should be errors thrown when there is a render failure. 4. Ability to reset and clear. 5. Ability to save documents

One advanced java feature to help: Usage of reflection is useful so that long switch statements are not needed in the construction of a expression tree structure. 

What feature are you most excited on working: Actually rendering things on the view/working on the expression tree. 

What feature are you most worried about working on: Error throwing could be troublesome for this assignment. 