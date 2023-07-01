import java.awt.Color;

public class MoveLetter extends Letter {
    private boolean direction;

    public MoveLetter() {
        super(Color.BLUE, 2);

        if(((int) (Math.random() * 2)) == 1) {
            direction = true;
        } else {
            direction = false;
        }
    }

    @Override
    public void move() {
        if(super.x >= 1467 || super.x <= 0) {
            direction = !direction;
        }

        if(direction == true) {
            super.x += super.speed;
            super.y += super.speed;
        } else {
            super.x -= super.speed;
            super.y += super.speed;
        }
    }
}
