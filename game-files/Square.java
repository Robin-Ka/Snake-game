import java.awt.*;
import javax.swing.*;

public class Square extends JPanel {
    public final int row;
    public final int coloumn;

    public void resetColor() {
        this.setBackground(Color.black);
    }

    public Square(int row, int coloumn) {
        this.row = row;
        this.coloumn = coloumn;

        this.resetColor();
    }

}