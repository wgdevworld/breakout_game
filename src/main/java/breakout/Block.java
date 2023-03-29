package breakout;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

/**
 * @author Woonggyu Jin
 */

public class Block extends Rectangle {

  public static final int BLOCK_XSIZE = Main.SIZE / 6;
  public static final int BLOCK_YSIZE = 30;
  //arbitrary number set to keep the block from spawning at a position that's too low
  public static final Color DUKE_BLUE = new Color(0, 0.188, 0.529, 1);
  // arbitrary number set to remove the block from the scene
  private static final int OUT_OF_BOUNDS = 1000;
  private int hitsLeft;
  Bounds blockBounds;


  public Block(int xPos, int yPos, int hitsLeft) {
    this.setWidth(BLOCK_XSIZE);
    this.setHeight(BLOCK_YSIZE);
    this.setFill(DUKE_BLUE);
    this.setX(xPos);
    this.setY(yPos);
    this.hitsLeft = hitsLeft;
    this.blockBounds = this.getBoundsInParent();
  }

  /**
   * "Remove the block" by sending it out of the screen
   */
  public void remove() {
    this.setX(OUT_OF_BOUNDS);
  }

  /**
   * Get number of hits left on block
   */
  public int getHitsLeft() {
    return this.hitsLeft;
  }

  /**
   * Change the opacity of the block according to how many hits are left.
   */
  public void changeOpacity() {
    this.setOpacity(0.5 + this.hitsLeft / 10);
  }

  public void decrementHitsLeft() {
    this.hitsLeft--;
  }
}
