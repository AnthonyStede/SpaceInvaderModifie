import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javax.swing.JSlider;
import javax.swing.event.*;

public class OptionChangeListenerTest {
  @Test
  public void evaluatesGeneration() {
    Game gameTest = new Game();
    gameTest.setSpeedIncrease(1.2);
    double delta = 1e-15;

    //Definition of the instance for the test
    OptionChangeListener optionChgList = new OptionChangeListener(gameTest) {
      public void stateChanged(ChangeEvent event)
      {
        this.modifiedGame.setSpeedIncrease((((JSlider)event.getSource()).getValue()*0.1)+1.0);
      }
    };

    JSlider speedIncreaseSlider = new JSlider();
    speedIncreaseSlider.setMaximum(10);
    speedIncreaseSlider.setMinimum(0);
    speedIncreaseSlider.setMinorTickSpacing(1);
    speedIncreaseSlider.setValue((int)((gameTest.getSpeedIncrease()-1)*10));
    speedIncreaseSlider.addChangeListener(optionChgList);

    //tests if the slider is generated with the right values
    assertEquals((speedIncreaseSlider.getValue()*0.1)+1.1, gameTest.getSpeedIncrease(), delta);
  }

  @Test
  public void evaluatesChanges() {
    Game gameTest = new Game();
    gameTest.setSpeedIncrease(1.2);
    double delta = 1e-15;

    //Definition of the instance for the test
    OptionChangeListener optionChgList = new OptionChangeListener(gameTest) {
      public void stateChanged(ChangeEvent event)
      {
        this.modifiedGame.setSpeedIncrease((((JSlider)event.getSource()).getValue()*0.1)+1.0);
      }
    };

    JSlider speedIncreaseSlider = new JSlider();
    speedIncreaseSlider.setMaximum(10);
    speedIncreaseSlider.setMinimum(0);
    speedIncreaseSlider.setMinorTickSpacing(1);
    speedIncreaseSlider.setValue((int)((gameTest.getSpeedIncrease()-1)*10));
    speedIncreaseSlider.addChangeListener(optionChgList);

    //test if it follows the changes
    speedIncreaseSlider.setValue(5);
    assertEquals((speedIncreaseSlider.getValue()*0.1)+1.0, gameTest.getSpeedIncrease(), delta);
  }
}
