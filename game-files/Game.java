import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Game {

    public Snake snake;
    public Grid grid;
    public Frame frame;

    public boolean running = false;
    public int direction = RIGHT;
    public boolean directionChanged = false;
    public double speed = 5;
    public ArrayList<Square> food;
    public int points = 0;

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

        // Wrap around logic
        // try {
        // switch (this.direction) {
        // case LEFT:
        // next = this.grid.getSquare((head.row - 1 + 12) % 12, head.column);
        // break;
        // case RIGHT:
        // next = this.grid.getSquare((head.row + 1) % 12, head.column);
        // break;
        // case UP:
        // next = this.grid.getSquare(head.row, (head.column - 1 + 12) % 12);
        // break;
        // case DOWN:
        // next = this.grid.getSquare(head.row, (head.column + 1) % 12);
        // break;
        // }
        // }

        try {
            switch (this.direction) {
                case LEFT:
                    next = this.grid.getSquare(head.row - 1, head.column);
                    break;

                case RIGHT:
                    next = this.grid.getSquare(head.row + 1, head.column);
                    break;

                case UP:
                    next = this.grid.getSquare(head.row, head.column - 1);
                    break;

                case DOWN:
                    next = this.grid.getSquare(head.row, head.column + 1);
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
            this.frame.updatePoints(this.points);

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
        this.directionChanged = false;
    }

    public void giveDirection(int newDirection) {
        if (!this.directionChanged) {
            this.direction = newDirection;
            this.directionChanged = true;
        }

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
        this.sleep((int) (1000 / this.speed));
    }

    private void sleep(int milSek) {
        try {
            Thread.sleep(milSek);
        } catch (InterruptedException exception) {
            System.err.println("An error occured!");
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
        this.snake = new Snake(this.grid.getSquare(30 / 2, 30 / 2));
        this.food = new ArrayList<>();
        this.frame.keys(this);

        for (int i = 0; i < 1; i++) {
            this.makeFood();
        }

        while (this.running) {
            this.movementSpeed();
            this.moveSnake();
        }
    }

}