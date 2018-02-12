import javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;

abstract class OptionChangeSpriteListener implements ActionListener {
  Game modifiedGame;

  public OptionChangeSpriteListener(Game game){
    super();
    this.modifiedGame = game;
  }
}
