@authoer Sean Hudson (srh50)
Worked with ct168, eml36

## Part 1

#### 1. What about your API/design is intended to be flexible

The model should not have any real interaction with the the
front end. Therefore the design should be pretty flexible for
what type of front end is plugged into it. It should also be very
extensible for additional commands.

#### 2. How is your API/design encapsulating you implementation decision?

The model will encapsulate all of its data and use internal api's
for working flexibility. It will communicate with front end only
through specific external api calls. The Front end will be bound
to the back end so the back end will encapsulate all the data but
the front end will observe it and make changes accordingly.

#### 3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)

There could be semantic and syntax exceptions that the Backend throws up to the front end

**Syntax** - As the parser is creating the tree if it reads in an invalid input command
it will throw an invalidCommandSyntaxException

**Semantics** - As the backend is traversing the tree, if it encounters an improperly formatted
node it will throw an invalidCommandSymantecException

#### 4. Why do you think your API/design is good (also define what your measure of good is)?

I think my API design is good because it is flexible, extensible and encapsulates its data.
My API does not require knowledge of the front end, which is good because it should be able
to work with any front end.

## Part 2

#### 1. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams)

  * User enters a valid command
  * User enters a command with invalid Syntax
  * User enters a command with invalid semantics
  * User binds their display to the observable grid
  * User saves a command

#### 2. How do you think at least one of the "advanced" Java features will help you implement your design

  Reflection will definitely help keep the code neat and prevent large switch statements or if-else control flows.

#### 3. What feature/design problem are you most excited to work on?

  I am excited to work on making the tree. I think it will be very interesting to make the tree from a command string.

#### 4. What feature/design problem are you most worried about working on?

  I am worried about maintaining no dependancies between the front end and back end.



## Notes

No underlying data storage structure

Parse string input into a Tree

automatically update the front end through an observable collection

Backend: keep track of points, history of commands, variables

bind input string to back end expression tree

Back end will create a parse tree and and will traverse it
while updating the data structure that is holding all of the points
This data structure will be observable and will correspond to the front
end display

Bind the fill of the polyline/turtle to color fields
