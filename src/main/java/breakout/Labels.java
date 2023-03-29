package breakout;


import static breakout.Main.myLives;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * @author Woonggyu Jin
 */

public class Labels extends Label {

  private static final int GAMEOVER_XSIZE = 50;
  private static final int GAMEOVER_YSIZE = 10;


  public Labels(String text, Node graphic) {
    super(text, graphic);
  }

  /**
   * Initialize position and size of game over message
   */
  public void initializeGameOverMsg() {
    this.relocate(Main.SIZE / 2 - GAMEOVER_XSIZE / 2, Main.SIZE / 2 - GAMEOVER_YSIZE / 2);
    this.setWidth(GAMEOVER_XSIZE);
    this.setHeight(GAMEOVER_YSIZE);
  }

  /**
   * Initialize position of lives left message
   */
  public void initializeLivesMsg() {
    this.relocate(0, 0);
  }

  /**
   * Update how many lives are left on message
   */
  public void updateLivesMsg() {
    this.setText("Lives Left: " + myLives.getMyRemainingLives());
  }
}
