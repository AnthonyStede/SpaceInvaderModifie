import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javax.swing.*;
import javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;

  public class OptionChangeSpriteTest {
  @Test
  public void changeSprite() {
    Game gameTest = new Game();
    /** The sprite of alien */
    gameTest.setAlienSprite("sprites/alien.gif");
    /** The sprite of ship */
    gameTest.setShipSprite("sprites/ship.gif");
    /** The sprite of shot */
    gameTest.setShotSprite("sprites/shot.gif");

    //Definition of the instance for the test
    OptionChangeSpriteListener optionChgSpriteList = new OptionChangeSpriteListener(gameTest) {
      public void actionPerformed(ActionEvent event)
      {
        this.modifiedGame.setShipSprite("sprites/ship2.gif");
        this.modifiedGame.setShotSprite("sprites/shot3.gif");
      }
    };
    gameTest.setShipSprite("sprites/ship2.gif");
    gameTest.setShotSprite("sprites/shot3.gif");
    //tests if the Sprite has been changed
    assertEquals(gameTest.getAlienSprite(), "sprites/alien.gif");
    assertEquals(gameTest.getShipSprite(), "sprites/ship2.gif");
    assertEquals(gameTest.getShotSprite(), "sprites/shot3.gif");
  }
}
