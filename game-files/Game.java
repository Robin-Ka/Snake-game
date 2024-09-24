import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Game {

    private Snake snake;
    private Grid grid;
    private Frame frame;

    private boolean running = false;
    private int direction = RIGHT;
    private double speed = 2.5;
    private ArrayList<Square> food;
    private int points = 0;

    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int DOWN = 4;

    public Game() {

        this.grid = new Grid();
        this.frame = new Frame(this.grid);

        this.frame.setTitle("Snake Game");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 800);
        this.frame.setVisible(true);
    }

    public void moveSnake() {
        Square head = this.snake.getHead();
        Square next = null;

        try {
            switch (this.direction) {
                case LEFT:
                    next = this.grid.getSquare(head.row - 1, head.coloumn);
                    break;

                case RIGHT:
                    next = this.grid.getSquare(head.row + 1, head.coloumn);
                    break;

                case UP:
                    next = this.grid.getSquare(head.row, head.coloumn - 1);
                    break;

                case DOWN:
                    next = this.grid.getSquare(head.row, head.coloumn + 1);
                    break;
            }
        }

        catch (ArrayIndexOutOfBoundsException exception) {
            this.quit();
            return;
        }

        if (this.food.contains(next)) {
            this.food.remove(next);
            this.makeFood();

            this.points++;

            if (this.speed < 2.5) {
                this.speed += 0.1;
            }
        }

        else {
            this.snake.removeTail();
        }

        if (this.snake.hits(next)) {
            this.quit();
        }

        this.snake.addSquare(next);
    }

    public void giveDirection(int newDirection) {
        this.direction = newDirection;
    }

    public void makeFood() {
        ArrayList<Square> squares = new ArrayList<>();

        for (Square square : this.grid.getAll()) {
            if (!this.snake.hits(square) && !this.food.contains(square)) {
                squares.add(square);
            }
        }

        if (squares.size() != 0) {
            int x = squares.size() - 1;
            int random = (int) (Math.random() * (x));

            Square newFood = squares.get(random);

            this.food.add(newFood);
            newFood.setBackground(Color.red);

        }
    }

    private void movementSpeed() {
        this.sleep((int) (1500.0 / this.speed));
    }

    private void sleep(int milSek) {
        try {
            Thread.sleep(milSek);
        } catch (InterruptedException exception) {
            System.err.println("Det oppstod en feil!");
        }
    }

    public void quit() {
        this.running = false;

        this.sleep(500);

        this.frame.remove(this.grid);
        this.frame.showPoints(this.points);
    }

    public void start() {
        this.running = true;
        this.snake = new Snake(this.grid.getSquare(12 / 2, 12 / 2));
        this.food = new ArrayList<>();
        this.frame.keys(this);

        for (int i = 0; i < 3; i++) {
            this.makeFood();
        }

        while (this.running) {
            this.movementSpeed();
            this.moveSnake();
        }
    }

}