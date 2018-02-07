import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.BoxLayout;
import javax.swing.JLabel;


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
    this.setLayout(new BoxLayout(this.getContentPane(), 1));

    /**
    * We add a JSlider to the option pane and depending on it's value it will
    * change the value for the speed increase in the game in real time.
    */
    JSlider speedIncreaseSlider = new JSlider();
    speedIncreaseSlider.setMaximum(10);
    speedIncreaseSlider.setMinimum(0);
    speedIncreaseSlider.setMinorTickSpacing(1);
    speedIncreaseSlider.setValue((int)((this.game.getSpeedIncrease()-1)*10));
    speedIncreaseSlider.addChangeListener(new OptionChangeListener(this.game){
      public void stateChanged(ChangeEvent event){
        this.modifiedGame.setSpeedIncrease((((JSlider)event.getSource()).getValue()*0.1)+1.0);
      }
    });

    /**
    * We add a JSlider to the option pane and depending on it's value it will
    * change the value for the move speed of the ship game in real time.
    */
    JSlider moveSpeedSlider = new JSlider();
    moveSpeedSlider.setMaximum(600);
    moveSpeedSlider.setMinimum(1);
    moveSpeedSlider.setMinorTickSpacing(10);
    moveSpeedSlider.setValue((int)this.game.getMoveSpeed());
    moveSpeedSlider.addChangeListener(new OptionChangeListener(this.game){
      public void stateChanged(ChangeEvent event){
        this.modifiedGame.setMoveSpeed((double)(((JSlider)event.getSource()).getValue()));
      }
    });


    JPanel speedIncreasePan = new JPanel();
    speedIncreasePan.add(new JLabel ("Select the speed increase coefficient after an Alien dies : "));
    speedIncreasePan.add(speedIncreaseSlider);
    this.add(speedIncreasePan);

    JPanel moveSpeedPan = new JPanel();
    moveSpeedPan.add(new JLabel ("Select the speed of the ship :             "));
    moveSpeedPan.add(moveSpeedSlider);
    this.add(moveSpeedPan);

    this.setTitle("Options");
    this.setSize(400, 400);
    this.setVisible(true);
  }
}
