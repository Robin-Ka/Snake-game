import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Grid extends JLabel {
    public final Square[][] map;

    public Grid() {
        this.map = new Square[12][12];
        this.setLayout(new GridLayout(12, 12));

        for (int column = 0; column < 12; column++) {
            for (int row = 0; row < 12; row++) {
                Square square = new Square(row, column);

                this.map[column][row] = square;

                this.add(square);

            }
        }
    }

    public Square getSquare(int row, int column) {
        return this.map[column][row];
    }

    public ArrayList<Square> getAll() {
        ArrayList<Square> squares = new ArrayList<>();
        for (Square[] row : this.map) {
            for (Square square : row) {
                squares.add(square);
            }
        }
        return squares;
    }
}