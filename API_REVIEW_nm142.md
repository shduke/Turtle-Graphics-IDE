People: Noel Moon (nm142), Young Song (ys101)

##Part 1

1. The command interpreter should be flexible to account for multiple languages and having to add new commands. The data structure that holds the commands that the terminal should be able to respond to should be flexible to be able to add new commands like changing the color or changing the image of the turtle.

2. The process of adding new interpretable commands should be encapsulated so that the details of adding new commands is hidden, but the simple process of adding it is available to the public.

3. Invalid terminal input would have to be handled. The exception handler should check that the first word of the command is always something that it can interpret like forward or left. After the first part of the command is determined, the second part should be checked to make sure it is compatible with the first part. For example, there should be a way to throw an error if the command is "forward blue" or "setTurtleColor 50".

4. I think the API is good because it is flexible enough to account for multiple languages and can add new commands in the future. It is functional enough to respond to the variety of possible user inputs, and it can take care of possible invalid inputs. My measure of good is how flexible and how functional an API will be. If the API can take care of likely changes to the program like in this case, adding new commands, then it is flexible.

## Part 2

1. (1) The user inputs forward but doesn't specify the distance. (2) The user inputs forward but gives a color instead of a distance. (3) The user tries to change the turtle image to an image that isn't one of the possible images. (4) The user inputs an incomprehensible command. (5) The user has no command at all in the input

2. Generic Types will probably be used for storing the user's command. The command may be forward, right, changeColor, etc. and the type of the command would have to be generic to accommodate those different commands. 

3. I am most excited about working on interpreting the user input to something that the front end will be able to understand.

4. I am most worried about handling all of the different types of errors that the user could input. Many of the use cases in Question 1 are some of the concerns that I have for the program.