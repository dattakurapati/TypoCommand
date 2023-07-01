import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class Letter extends JPanel {
    protected int x;
    protected int y;
    protected int speed;
    private Color color;
    private String[] alphalist = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String letter;
    private int lives;
    
    public Letter() {
        x = (int) (Math.random() * 1467) + 10;
        y = 0;
        speed = 2;
        color = Color.black;
        letter = alphalist[(int) (Math.random() * 26)];
    }

    public Letter(Color color, int speed) {
        x = (int) (Math.random() * 1467) + 10;
        y = 0;
        this.speed = speed;
        this.color = color;
        letter = alphalist[(int) (Math.random() * 26)];
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.setFont(new Font("Monospaced", Font.BOLD, 30));
        g.drawString(letter, x, y);
    }

    public void move() {
        y += speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLetter() {
        char character = letter.charAt(0);
        int ascii = (int) character;
        return ascii;
    }

    public Rectangle letterGetBounds() {
        return new Rectangle(x, y-20, 18, 20);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int s) {
        lives--;
    }

    public boolean isStrong() {
        return false;
    }
}
