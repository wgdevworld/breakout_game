package breakout;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Woonggyu Jin
 */

public class Bouncer extends Circle {

  private final int BOUNCER_SIZE = 10;
  private int BOUNCER_SPEED_X = 200;
  private int BOUNCER_SPEED_Y = 200;
  Bounds ballBounds;

  public Bouncer() {
    this.setRadius(BOUNCER_SIZE);
    this.setFill(Color.LIGHTSTEELBLUE);
    this.ballBounds = this.getBoundsInParent();
  }

  /**
   * Initialize bouncer's position
   */
  public void initialize() {
    this.setCenterX(Main.SIZE - BOUNCER_SIZE);
    this.setCenterY(Main.SIZE / 2 - BOUNCER_SIZE);
  }

  /**
   * Update bouncer's position and change direction if hit the left, top, or right "walls"
   */
  public void update(double elapsedTime) {
    if (this.getCenterX() > Main.SIZE - BOUNCER_SIZE | this.getCenterX() < BOUNCER_SIZE) {
      this.BOUNCER_SPEED_X = -this.BOUNCER_SPEED_X;
    }
    if (this.getCenterY() < BOUNCER_SIZE) {
      this.BOUNCER_SPEED_Y = -this.BOUNCER_SPEED_Y;
    }
    this.setCenterX(this.getCenterX() + BOUNCER_SPEED_X * elapsedTime);
    this.setCenterY(this.getCenterY() + BOUNCER_SPEED_Y * elapsedTime);
  }

  /**
   * Return true if player misses the ball with the paddle.
   */
  public boolean miss() {
    if (this.getCenterY() > Main.SIZE - BOUNCER_SIZE) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Shifts ball off the screen
   */
  public void remove() {
    this.setCenterX(1000);
    ;
  }

  /**
   * Return which part of the paddle the bouncer hit as String. Null if it didn't.
   */
  public String paddleHitArea(Rectangle a) {
    if (this.getBoundsInParent()
        .intersects(a.getX(), a.getY(), Paddle.PADDLE_XSIZE / 3, Paddle.PADDLE_YSIZE)) {
      return "left";
    } else if (this.getBoundsInParent()
        .intersects(a.getX() + Paddle.PADDLE_XSIZE / 3, a.getY(), Paddle.PADDLE_XSIZE / 3,
            Paddle.PADDLE_YSIZE)) {
      return "middle";
    } else if (this.getBoundsInParent()
        .intersects(a.getX() + 2 * Paddle.PADDLE_XSIZE / 3, a.getY(), Paddle.PADDLE_XSIZE / 3,
            Paddle.PADDLE_YSIZE)) {
      return "right";
    }
    return null;
  }

  /**
   * Changes direction of bouncer based on which area the ball hit.
   */
  public void bounceOffPaddle(Paddle p) {
    if (this.paddleHitArea(p) != null) {
      if (this.paddleHitArea(p).equals("left") | this.paddleHitArea(p).equals("right")) {
        this.reverseX();
        this.reverseY();
      } else if (this.paddleHitArea(p).equals("middle")) {
        this.reverseY();
      }
    }
  }

  /**
   * Returns true if bouncer bounced off top or bottom of block
   */
  public boolean bounceOffBlockTopBottom(Block b) {
    if (this.intersects(b.getBoundsInLocal())) {
      Bounds boundsInScene = this.localToScene(this.getBoundsInLocal());
      double ballMinY = boundsInScene.getMinY();
      double ballMaxY = boundsInScene.getMaxY();
      Bounds blockBounds = b.localToScene(b.getBoundsInLocal());
      double blockMinY = blockBounds.getMinY();
      double blockMaxY = blockBounds.getMaxY();
      return (ballMinY < blockMinY || ballMaxY > blockMaxY);
    } else {
      return false;
    }
  }

  /**
   * Returns true if bouncer bounced off sides of block
   */
  public boolean bounceOffBlockSide(Block b) {
    if (this.intersects(b.getBoundsInLocal())) {
      Bounds boundsInScene = this.localToScene(this.getBoundsInLocal());
      double ballMinX = boundsInScene.getMinX();
      double ballMaxX = boundsInScene.getMaxX();
      Bounds blockBounds = b.localToScene(b.getBoundsInLocal());
      double blockMinX = blockBounds.getMinX();
      double blockMaxX = blockBounds.getMaxX();
      return (ballMinX < blockMinX || ballMaxX > blockMaxX);
    } else {
      return false;
    }
  }

  /**
   * Reverse the horizontal direction of the ball, effectively creating a bouncing effect.
   */
  public void reverseY() {
    this.BOUNCER_SPEED_Y = -this.BOUNCER_SPEED_Y;
  }

  /**
   * Reverse the horizontal and vertical direction of the ball, effectively creating a bouncing
   * effect.
   */
  public void reverseX() {
    this.BOUNCER_SPEED_X = -this.BOUNCER_SPEED_X;
  }
}
