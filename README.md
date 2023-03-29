# breakout

## Woonggyu Jin

This project implements the game of Breakout.

### Timeline

* Start Date: 1/19

* Finish Date: 1/24

* Hours Spent: 30

### Attributions

* Resources used for learning (including AI assistance)
    * I used ChatGPT to figure out collision detection logic when the bouncer hit the paddle.

* Resources used directly (including AI assistance)
    * El Capitan spinning beachball GIF by madebyjw.com
      -- https://gfycat.com/rapidathleticilladopsis

### Running the Program

* Main class:
    * The main class is the "playing field" where the objects interact with behavior that are
defined as methods in the corresponding abstractions.

* Data files needed:
    * None

* Key/Mouse inputs:
    * Left and right keys shift the paddle

* Cheat keys:
    * None implemented

### Notes/Assumptions

* Assumptions or Simplifications:
    * Removing block simply moves it outside the screen to an arbitrarily set X-coordinate

* Known Bugs:
    * The collision detection mechanism seems to be off when the ball hits near the corner of the
      block (counts as two hits instead of one)

* Features implemented:
    * Collision detection
    * Paddle that moves around the screen and warps to the other side if it leaves the screen
    * Blocks that require multiple hits to be removed and change color according to hits left
    * Label at top left corner with how many lives a player has left.
    * Game over message once player has no more lives left.

* Features unimplemented:
    * Power up and levels.

* Noteworthy Features:

### Assignment Impressions

Coming straight from CS210 I didn't even know what the word refactor meant until last week. I
thought
the larger purpose of the project was to practice writing DRY code and refactoring code, so I spent
a lot of time doing that. Learning JavaFX and programming logic that I didn't know at all at the
same time was definitely cumbersome, but this project has definitely made me toughen up. Although it
may not seem like much, I think I learned more about programming in the past week than the entirety
of my previous time studying computer science. 
