import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    public Frame(Grid grid) {

        this.add(grid);
    }

    public void showPoints(int points) {

        String totPoints = ("Points: " + points);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(totPoints);
        label.setFont(new Font("Times New Roman", 1, 80));

        panel.add(label);
        this.add(panel);

        this.validate();
    }

    public void keys(Game game) {

        this.addKeyListener(new Controller(game));
    }
}