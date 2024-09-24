import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Grid extends JLabel {
    public final Square[][] map;

    public Grid() {
        this.map = new Square[12][12];
        this.setLayout(new GridLayout(12, 12));

        for (int coloumn = 0; coloumn < 12; coloumn++) {
            for (int row = 0; row < 12; row++) {
                Square square = new Square(row, coloumn);

                this.map[coloumn][row] = square;

                this.add(square);

            }
        }
    }

    public Square getSquare(int row, int coloumn) {
        return this.map[coloumn][row];
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