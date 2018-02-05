import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;


/**
 *  An option pane designed to allow the user to easily change
 *  the games' settings, such as difficulty, sprites and sound (N.I.)
 * @author Valentin Roche & Anthony Stede-Schrader
 */

public class OptionPane extends JFrame {

  JPanel contentPane;
  Game game;

  public OptionPane(Game originGame) {
    this.contentPane = (JPanel) this.getContentPane();
    this.game = originGame;

    /**
    * We add a JSlider to the option pane and depending on it's value it will
    * change the value for the game in real time.
    */
    JSlider speedIncreaseSlider = new JSlider();
    speedIncreaseSlider.setMaximum(10);
    speedIncreaseSlider.setMinimum(0);
    speedIncreaseSlider.setMinorTickSpacing(1);
    speedIncreaseSlider.setValue(2);
    speedIncreaseSlider.addChangeListener(new OptionChangeListener(this.game){
      public void stateChanged(ChangeEvent event){
        this.modifiedGame.setSpeedIncrease((((JSlider)event.getSource()).getValue()*0.1)+1.0);
      }
    });

    this.add(speedIncreaseSlider);
    this.setTitle("Options");
    this.setSize(400, 400);
    this.setVisible(true);
  }
}
