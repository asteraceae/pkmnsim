Pokemon Battle Simulator

Abstract
This project concerns the development of a game centered upon ‘battles’ between two players or one player against an AI.  This game is based off the popular series “Pokemon,” and the goal is to emulate the battle function found in the game series.  The game will utilize a graphical interface and multiple pages, such as the start screen, the “choose your fighter” screen, and the actual battle screen.  Additionally, the game will also allow for the user(s) to choose their own team or have the program randomize a selection for them.
The main function/attraction of this program is the battle simulator.  Though the options will be relatively simple (pick a move, view how much damage it will cause against the opponent, pick a move again), we aim to also emulate the complex algorithms, hidden stats/modifiers, and etc found in the actual Pokemon game series.  Many factors hidden from the user--move-type and pokemon-type, pokemon’s nature, status effects, etc--determine what a chosen move’s power will be, meaning that movesets are not “one-size fits all.”  These complex hidden factors aim to involve thought and strategy into the game, and the goal is to properly simulate the above in this program.  

Project Design
	This project will be designed using the Java language.  This was in part because of our team member’s shared familiarity with the language as well as its capabilities for creating a graphical UI while also managing large amounts of data.  The graphical UI will be created using Java’s Swing libraries, which offer the ability to create simple layouts with our desired labels, buttons, menus, and images.  Additionally, we plan to develop the code using the softwares Atom or IntelliJ Idea, which both sufficiently meet our needs for the project.
	The program itself will feature a graphical UI.  There will be a start splash screen with a button, a team chooser screen with drop down menus with the ability to type in names of Pokemon or randomize a selection (limited to the first generation/151 characters for now, also shown in figure 1 below), and then, the actual battle which will feature an image of the current chosen Pokemon, a health bar that updates periodically, and menus to choose a move with an associated button.  There will be a separate class(es) that will manage all of the data associated with moves and Pokemon.  To reduce complexity and encourage readability of the code, a lot of the data is planned to be stored in either .json or .txt files where it can be retrieved as needed.


Hint:
This program must be run from the command prompt through running 'main.'
Navigate using the buttons to make choices as necessary.
