import java.awt.Color;
import java.awt.Graphics;

public class StrongLetter extends Letter {
    private int lives;
    public StrongLetter() {
        super(Color.RED, 2);
        lives = 3;
    }

    public void paint(Graphics g) {
        super.paint(g);
        if(lives == 3) {
            g.fillOval(x + 1, y-28, 5, 5);
            g.fillOval(x + 7, y-28, 5, 5);
            g.fillOval(x + 13, y-28, 5, 5);
        } else if (lives == 2) {
            g.fillOval(x + 1, y-25, 5, 5);
            g.fillOval(x + 7, y-25, 5, 5);
        } else {
            g.fillOval(x + 1, y-25, 5, 5);
        }
    }

    public void setLives(int s) {
        lives--;
        
    }

    public int getLives() {
        return lives;
    }

    public boolean isStrong() {
        return true;
    }
}
