import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  An option pane designed to allow the user to easily change
 *  the games' settings, such as difficulty, sprites and sound (N.I.)
 * @author Valentin Roche & Anthony Stede-Schrader
 */

public class OptionPane extends JFrame {

  JPanel contentPane;
  Game game;

  public OptionPane(Game originGame) {
    System.out.println("zbleh v3");
    this.contentPane = (JPanel) this.getContentPane();
    this.game = originGame;

    this.setTitle("Options");
    this.setSize(400, 400);
    this.setVisible(true);
  }
}
