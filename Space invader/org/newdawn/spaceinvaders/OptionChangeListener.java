import javax.swing.event.*;

abstract class OptionChangeListener implements ChangeListener {
  Game modifiedGame;

  public OptionChangeListener(Game game){
    super();
    this.modifiedGame = game;
  }
}
