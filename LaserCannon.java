import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class LaserCannon {
    public LaserCannon() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        int [] x = {745,815, 675};
        int [] y = {665,800,800};
        g.drawPolygon(x, y, 3);
        g.fillPolygon(x, y, 3);
    }

    public Polygon polyGetBounds() {
        int [] x = {745,815, 675};
        int [] y = {665,800,800};
        return new Polygon(x, y, 3);
    }

}
