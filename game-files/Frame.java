import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    private JLabel pointsLabel;

    public Frame(Grid grid) {
        this.add(grid);
        pointsLabel = new JLabel("Points: 0", SwingConstants.CENTER);
        pointsLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        this.add(pointsLabel, BorderLayout.NORTH); // Add label to the top
    }

    public void updatePoints(int points) {
        pointsLabel.setText("Points: " + points); // Update points display
    }

    public void showPoints(int points) {
        pointsLabel.setVisible(false);
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