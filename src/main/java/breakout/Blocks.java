package breakout;

import java.util.ArrayList;

/**
 * @author Woonggyu Jin
 */

public class Blocks extends ArrayList<Block> {

  private static final int NUM_BLOCKS = 30;
  private static final int NUM_ROW = 6;
  private static final int X_GAP = (Main.SIZE - 6 * Block.BLOCK_XSIZE) / 2;
  private static final int Y_GAP = 5;
  private static final int MSG_GAP = 18;

  public Blocks() {
  }

  /**
   * Add blocks to the arraylist of blocks
   */
  public void addBlocks() {
    for (int i = 0; i < NUM_BLOCKS; i++) {
      if (i < NUM_ROW) {
        this.add(new Block((i % 6) * Block.BLOCK_XSIZE + X_GAP, MSG_GAP, 2));
      } else if (i < 2 * NUM_ROW) {
        this.add(
            new Block((i % 6) * Block.BLOCK_XSIZE + X_GAP, Block.BLOCK_YSIZE + Y_GAP + MSG_GAP, 2));
      } else if (i < 3 * NUM_ROW) {
        this.add(
            new Block((i % 6) * Block.BLOCK_XSIZE + X_GAP,
                2 * (Block.BLOCK_YSIZE + Y_GAP) + MSG_GAP, 2));
      } else if (i < 4 * NUM_ROW) {
        this.add(
            new Block((i % 6) * Block.BLOCK_XSIZE + X_GAP,
                3 * (Block.BLOCK_YSIZE + Y_GAP) + MSG_GAP, 2));
      } else {
        this.add(
            new Block((i % 6) * Block.BLOCK_XSIZE + X_GAP,
                4 * (Block.BLOCK_YSIZE + Y_GAP) + MSG_GAP, 2));
      }
    }
  }
}
