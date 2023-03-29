package breakout;

import javafx.scene.input.KeyCode;

/**
 * @author Woonggyu Jin
 */

public class Lives {

  private int myRemainingLives;

  public Lives() {
    myRemainingLives = 3;
  }

  public int getMyRemainingLives() {
    return myRemainingLives;
  }

  public void decrementLives() {
    this.myRemainingLives--;
  }

}
