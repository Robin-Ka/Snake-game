import java.util.*;
import java.awt.*;

public class Snake {
    private ArrayList<Square> body;

    public Snake(Square start) {
        this.body = new ArrayList<>();
        this.addSquare(start);
    }

    public boolean hits(Square rute) {
        return this.body.contains(rute);
    }

    public void addSquare(Square rute) {
        this.body.add(rute);
        rute.setBackground(Color.green);
    }

    public Square getHead() {
        return this.body.get(this.body.size() - 1);
    }

    public void removeTail() {
        Square tail = this.body.remove(0);
        tail.resetColor();
    }

}