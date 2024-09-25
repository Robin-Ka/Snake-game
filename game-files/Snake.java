import java.util.*;
import java.awt.*;

public class Snake {
    private ArrayList<Square> body;

    public Snake(Square start) {
        this.body = new ArrayList<>();
        this.addSquare(start);
    }

    public boolean hits(Square square) {
        return this.body.contains(square);
    }

    public void addSquare(Square square) {
        this.body.add(square);

        square.setBackground(Color.green.darker()); // Set the head color

    }

    public Square getHead() {
        return this.body.get(this.body.size() - 1);
    }

    public void removeTail() {
        Square tail = this.body.remove(0);
        tail.resetColor();
    }

}