package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author Woonggyu Jin
 */

public class Main extends Application {

  // scene contains all the shapes and has several useful methods
  private Scene myScene;
  Timeline animation = new Timeline();
  public static final int FRAMES_PER_SECOND = 60;
  public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
  public static final Paint BACKGROUND = Color.AZURE;

  // useful names for constant values used
  public static final String TITLE = "Example JavaFX Animation";
  public static final int SIZE = 400;

  //actors
  public static final Bouncer myBouncer = new Bouncer();
  public static final Paddle myPaddle = new Paddle();
  public static Lives myLives = new Lives();
  private static final Labels gameOverMsg = new Labels("Game over!", null);
  private static final Labels livesMsg = new Labels("Lives Left: " + myLives.getMyRemainingLives(),
      null);
  public static Group root = new Group(myBouncer, myPaddle, livesMsg);
  public Blocks myBlocks = new Blocks();


  /**
   * Initialize what will be displayed.
   */
  @Override
  public void start(Stage stage) {
    // attach scene to the stage and display it
    myScene = setupScene(SIZE, SIZE, BACKGROUND);
    stage.setScene(myScene);
    stage.setTitle(TITLE);
    stage.show();

    // attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.getKeyFrames()
        .add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(SECOND_DELAY)));
    animation.play();
  }

  /**
   * Set up the scene and initialize shapes
   */
  public Scene setupScene(int width, int height, Paint background) {
    myBouncer.initialize();
    myPaddle.initialize();

    livesMsg.initializeLivesMsg();

    myBlocks.addBlocks();

    for (Block b : myBlocks) {
      root.getChildren().add(b);
    }

    myScene = new Scene(root, width, height, background);

    myScene.setOnKeyPressed(e -> myPaddle.move(e.getCode()));
    return myScene;
  }

  /**
   * Update actors to have correct behavior with elapsed time
   */
  private void step(double elapsedTime) {
    // update "actors" attributes a little at a time and at a "constant" rate (no matter how many frames per second)
    // update "actors" according to if they hit
    myBouncer.update(elapsedTime);
    if (myBouncer.miss()) {
      myBouncer.initialize();
      myLives.decrementLives();
      livesMsg.updateLivesMsg();
    }

    for (Block myBlock : myBlocks) {
      if (myBouncer.bounceOffBlockTopBottom(myBlock)) {
        myBlock.decrementHitsLeft();
        myBlock.changeOpacity();
        myBouncer.reverseY();
      } else if (myBouncer.bounceOffBlockSide(myBlock)) {
        myBlock.decrementHitsLeft();
        myBlock.changeOpacity();
        myBouncer.reverseX();
      }

      if (myBlock.getHitsLeft() == 0) {
        myBlock.remove();
      }
    }

    myBouncer.bounceOffPaddle(myPaddle);
    myPaddle.relocate();

    if (myLives.getMyRemainingLives() == 0) {
      myBouncer.remove();
      root.getChildren().add(gameOverMsg);
      gameOverMsg.initializeGameOverMsg();
      animation.pause();
    }
  }

  /**
   * Start program and give complete control to JavaFX
   */
  public static void main(String[] args) {
    launch(args);
  }
}
