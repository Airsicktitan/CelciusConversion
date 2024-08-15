import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MyFrame implements ChangeListener {
    private final JLabel label;
    private final JSlider slider;

    MyFrame(){
        JFrame frame = new JFrame("Celsius to Fahrenheit Conversion");
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Celsius to Fahrenheit conversion");

        label  = new JLabel();
        slider = new JSlider(-100, 100, 50);
        title.setFont(new Font("MV Boli", Font.PLAIN, 25));
        title.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        panel.add(title);

        slider.setPreferredSize(new Dimension(400, 200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

        label.setText("<HTML>°C = " + slider.getValue() + "<br>°F = " + fahrenheit(slider.getValue()) +"</HTML>");
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));

        panel.add(slider);
        panel.add(label);
        frame.add(panel);

        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateLabel(slider.getValue());
    }

    private void updateLabel(int c) {
        label.setText("<HTML>°C = " + slider.getValue() + "<br>°F = " + fahrenheit(slider.getValue()) +"</HTML>");
    }

    private float fahrenheit(float c) {
        return c * 9/5 + 32;
    }
}
