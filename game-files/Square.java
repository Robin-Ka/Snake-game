import java.awt.*;
import javax.swing.*;

public class Square extends JPanel {
    public final int row;
    public final int column;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;

        this.resetColor();
    }

    public void resetColor() {
        this.setBackground(Color.black);
    }
}