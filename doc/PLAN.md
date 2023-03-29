# Breakout Plan
### Woonggyu Jin

## Interesting Breakout Variants

 * Idea #1
   * [Vortex](https://www.youtube.com/watch?v=YLHIybXCRbA) was interesting because instead of a standard breakout game
setup where the paddle is at the bottom and the bricks are above the paddle, this variation puts the bricks in the 
middle and the paddle moving in a circle at the outskirts.
 * Idea #2
   * [Bricks n Balls](https://www.youtube.com/watch?v=n7alxnfUhCE) was interesting because there were some blocks that
were triangles and the ball bounced off the vertices accordingly. Also, the implementation of an automatic speed-up
of the game when it seemed like the balls would bounce for a long time was fascinating.

## Paddle Ideas

 * Idea #1
   * Paddle where left and right thirds cause the ball to bounce back in the direction it came and the middle third 
causes the ball to bounce back normally.
 * Idea #2
   * Paddle warps to other side of the screen when it reaches the edge


## Block Ideas

 * Idea #1
   * A block that destroys all the bricks that are on the same horizontal line
 * Idea #2
   * Blocks that take multiple hits before being destroyed
 * Idea #3
   * "Bad" blocks: Blocks that generate more blocks if you hit them. In order to clear the level you should destroy all 
 blocks but the "bad" blocks.
 * Idea #4
   * Blocks that drop different power-ups once they are destroyed

## Power-up Ideas

 * Idea #1
   * Making the paddle wider
 * Idea #2
   * Makes the paddle move faster
 * Idea #3
   * Generate an extra ball
 * Idea #4
   * Allowing you to catch the ball and release at will a certain number of times


## Cheat Key Ideas

 * Idea #1
   * Destroy all bricks that are on the horizontal line closest to the brick
 * Idea #2
   * Speeding up or slowing down the ball at will
 * Idea #3
   * Clearing the level instantly
 * Idea #4
   * Resetting number of lives
 * Idea #5
   * Getting rid of all the "bad" blocks (refer to Idea #3 in section _Block Ideas_)


## Level Descriptions

#### Key: Number-Character
* Number: Represents number of times the block needs to be hit in order to be destroyed
* Character: Type of block
  * A: Blank block
  * B: Normal block
  * C: "Bad" block (refer to Idea #3 in section _Block Ideas_)
  * D: Block that destroys all the bricks that are on the same horizontal line
  * E: Block that makes paddle wider
  * F: Block that makes paddle move faster
  * G: Block that generates extra ball
  * H: Block that allows you to catch and release the ball at will a certain number of times


 * Idea #1
   
0-A 1-B	1-B	1-B 0-A 0-A

0-A 1-B 1-D 2-B 0-A 1-A

1-H 2-B 2-B 0-A 1-B 0-A

0-A 3-E 1-B 1-B 0-A 1-B

3-B 1-H 4-D 0-A 0-A 0-A

 * Idea #2
   * Variation: Introduction of "bad" blocks (refer to Idea #3 in section _Block Ideas_)

2-B 3-B	1-C	2-D 0-A 0-A

3-B 1-C 3-D 2-B 0-A 3-B

0-A 2-B 3-B 1-H 1-C 0-A

5-B 3-B 3-B 2-G 0-A 0-A

3-B 3-B 3-B 0-A 0-A 0-A



 * Idea #3
    * Variation: Blocks slowly get closer to the bottom of screen. If a block touches the bottom, the game is over
      regardless of number of lives.

0-A 1-C	1-C	5-G 0-A 1-G

0-A 4-B 5-B 2-B 0-A 1-A

1-H 4-B 4-B 0-A 3-F 0-A

0-A 5-E 0-A 3-G 4-B 0-A

0-A 1-C 4-D 0-A 0-A 0-A




## Class Ideas

 * Idea #1: Bouncer
   * initialize: set initial position of bouncer
   * update: allow the bouncer to move around the screen and bounce off the left, right, and top walls
   * miss: indicate whether the player missed the bouncer with the paddle
   * reverseY: reverse the vertical direction of the bouncer
   * reverseX: reverse the horizontal direction of the bouncer

 * Idea #2: Paddle
   * initialize: set initial position of paddle
   * move: move the paddle around according to 
   * setSpeed: change the speed of the paddle
   * setWidth: change the width of the paddle
   * setX: set the X-coordinate of the paddle

 * Idea #3: Blocks
   * initialize: initialize block's position
   * hit: decrement number of hits remaining to destroy block
   * destroy: destroy block instantly

 * Idea #4: Lives
   * initialize: initialize number of lives
   * decrement: decrement number of lives
   * increment: increment number of lives

