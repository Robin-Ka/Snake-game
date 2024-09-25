import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (this.game.direction != Game.RIGHT) {
                    this.game.giveDirection(Game.LEFT);
                }
                break;

            case KeyEvent.VK_RIGHT:
                if (this.game.direction != Game.LEFT) {
                    this.game.giveDirection(Game.RIGHT);
                }
                break;

            case KeyEvent.VK_UP:
                if (this.game.direction != Game.DOWN) {
                    this.game.giveDirection(Game.UP);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (this.game.direction != Game.UP) {
                    this.game.giveDirection(Game.DOWN);
                }
                break;

            default:
                break;
        }
    }
}