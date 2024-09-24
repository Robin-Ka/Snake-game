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
                this.game.giveDirection(Game.LEFT);
                break;

            case KeyEvent.VK_RIGHT:
                this.game.giveDirection(Game.RIGHT);
                break;

            case KeyEvent.VK_UP:
                this.game.giveDirection(Game.UP);
                break;

            case KeyEvent.VK_DOWN:
                this.game.giveDirection(Game.DOWN);
                break;

            default:
                break;
        }
    }
}