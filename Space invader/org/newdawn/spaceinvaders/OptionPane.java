import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Image;

/**
 *  An option pane designed to allow the user to easily change
 *  the games' settings, such as difficulty, sprites and sound (N.I.)
 * @author Valentin Roche & Anthony Stede-Schrader
 */

public class OptionPane extends JFrame {

  JPanel contentPane;
  Game game;
  ImageIcon alien1;
  ImageIcon alien2;
  ImageIcon alien3;
  ImageIcon ship1;
  ImageIcon ship2;
  ImageIcon ship3;
  ImageIcon shot1;
  ImageIcon shot2;
  ImageIcon shot3;

  public OptionPane(Game originGame) {
    this.contentPane = (JPanel) this.getContentPane();
    this.game = originGame;
    this.setLayout(new BoxLayout(this.getContentPane(), 1));

    alien1 = new ImageIcon("sprites/alien.gif");
    alien2 = new ImageIcon("sprites/alien2.gif");
    alien3 = new ImageIcon("sprites/alien3.gif");
    ship1 = new ImageIcon("sprites/ship.gif");
    ship2 = new ImageIcon("sprites/ship2.gif");
    ship3 = new ImageIcon("sprites/ship3.gif");
    shot1 = new ImageIcon("sprites/shot.gif");
    shot2 = new ImageIcon("sprites/shot2.gif");
    shot3 = new ImageIcon("sprites/shot3.gif");

    Image img = alien1.getImage() ;
    Image newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    alien1 = new ImageIcon( newimg );
    img = alien2.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    alien2 = new ImageIcon( newimg );
    img = alien3.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    alien3 = new ImageIcon( newimg );
    img = ship1.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    ship1 = new ImageIcon( newimg );
    img = ship2.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    ship2 = new ImageIcon( newimg );
    img = ship3.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    ship3 = new ImageIcon( newimg );
    img = shot1.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    shot1 = new ImageIcon( newimg );
    img = shot2.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    shot2 = new ImageIcon( newimg );
    img = shot3.getImage() ;
    newimg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
    shot3 = new ImageIcon( newimg );
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
    this.setSize(800, 800);
    this.setVisible(true);

    JPanel spriteAlien = new JPanel();
    spriteAlien.add(new JLabel ("Select the sprite of the aliens : "));
    JButton b1 = new JButton("", alien1);
    JButton b2 = new JButton("", alien2);
    JButton b3 = new JButton("", alien3);
    spriteAlien.add(b1);
    spriteAlien.add(b2);
    spriteAlien.add(b3);
    this.add(spriteAlien);

    JPanel spriteShip = new JPanel();
    spriteShip.add(new JLabel ("Select the sprite of the ship : "));
    JButton b4 = new JButton("", ship1);
    JButton b5 = new JButton("", ship2);
    JButton b6 = new JButton("", ship3);
    spriteShip.add(b4);
    spriteShip.add(b5);
    spriteShip.add(b6);
    this.add(spriteShip);

    JPanel spriteShot = new JPanel();
    spriteShot.add(new JLabel ("Select the sprite of the bullets : "));
    JButton b7 = new JButton("", shot1);
    JButton b8 = new JButton("", shot2);
    JButton b9 = new JButton("", shot3);
    spriteShot.add(b7);
    spriteShot.add(b8);
    spriteShot.add(b9);
    this.add(spriteShot);
  }
}
