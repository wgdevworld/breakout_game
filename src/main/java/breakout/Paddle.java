package breakout;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Woonggyu Jin
 */

public class Paddle extends Rectangle {

  public static final int PADDLE_XSIZE = 100;
  public static final int PADDLE_YSIZE = 10;
  public static final int PADDLE_X = Main.SIZE / 2 - PADDLE_XSIZE / 2;
  public static final int PADDLE_Y = Main.SIZE - PADDLE_YSIZE;
  public static final int PADDLE_SPEED = 8;
  public static final Color PADDLE_COLOR = Color.BLACK;

  public Paddle() {
    this.setWidth(PADDLE_XSIZE);
    this.setHeight(PADDLE_YSIZE);
    this.setFill(PADDLE_COLOR);
  }

  /**
   * Initialize paddle's position.
   */
  public void initialize() {
    this.setX(PADDLE_X);
    this.setY(PADDLE_Y);
  }

  /**
   * Allow the paddle to warp once it reaches the end of the screen
   */
  public void relocate() {
    if (this.getX() > Main.SIZE) {
      this.setX(0);
    } else if (this.getX() < -PADDLE_XSIZE) {
      this.setX(Main.SIZE);
    }
  }

  /**
   * Move paddle according to key input
   */
  public void move(KeyCode code) {
    if (code == KeyCode.RIGHT) {
      this.setX(this.getX() + PADDLE_SPEED);
    } else if (code == KeyCode.LEFT) {
      this.setX(this.getX() - PADDLE_SPEED);
    }
  }
}
