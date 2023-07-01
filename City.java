import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class City {
    protected int xPos, yPos, health;

    public City(int x, int y) {
        xPos = x;
        yPos = y;
        health = 4;

    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(xPos, yPos, 100, 75);
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, 100, 75);
        g.setColor(Color.CYAN);
        if(health == 4) {
            g.fillOval(xPos + 15, yPos + 34, 10, 10);
            g.fillOval(xPos + 35, yPos + 34, 10, 10);
            g.fillOval(xPos + 55, yPos + 34, 10, 10);
            g.fillOval(xPos + 75, yPos + 34, 10, 10);
        } else if (health == 3) {
            g.fillOval(xPos + 15, yPos + 34, 10, 10);
            g.fillOval(xPos + 35, yPos + 34, 10, 10);
            g.fillOval(xPos + 55, yPos + 34, 10, 10);
        } else if (health == 2) {
            g.fillOval(xPos + 15, yPos + 34, 10, 10);
            g.fillOval(xPos + 35, yPos + 34, 10, 10);
        } else {
            g.fillOval(xPos + 15, yPos + 34, 10, 10);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, 100, 75);
    }
}
