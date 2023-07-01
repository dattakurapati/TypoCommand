import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TypoCommand extends JPanel {
    private ArrayList<Letter> lets;
    private ArrayList<City> cities;
    private LaserCannon laser;
    private int secondCount;
    protected boolean game;
    private int hit;
    private int score;

    public TypoCommand() {
        lets = new ArrayList<>();
        cities = new ArrayList<>();
        laser = new LaserCannon();
        setSize(1500, 800);
        setBackground(Color.darkGray);

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e){

            }

            public void keyPressed(KeyEvent e){
                hit = e.getKeyCode();
            }

            public void keyReleased(KeyEvent e){

            }
        });

        setFocusable(true);
        createCities(8);
        game = true;
    }

    public void paint(Graphics g) {
        super.paint(g);

        laser.paint(g);

        for(int x = 0; x < cities.size(); x++) {
            cities.get(x).paint(g);
        }

        if(secondCount == 5) {
            int random = (int) (Math.random()*4) + 1;

            if(random == 1) {
                lets.add(new Letter());
            } else if (random == 2) {
                lets.add(new FastLetter());
            } else if (random == 3) {
                lets.add(new StrongLetter());
            } else if (random == 4) {
                lets.add(new MoveLetter());
            }

            secondCount = 0;
        }
    
        for(int x = 0; x < lets.size(); x++) {
            lets.get(x).paint(g);
            lets.get(x).move();
            for(int y = 0; y < cities.size(); y++) {
                if(cities.get(y).getBounds().intersects(lets.get(x).letterGetBounds())) {
                    lets.remove(x);
                    cities.get(y).health--;
                }
                if(cities.get(y).health == 0) {
                    cities.remove(y);
                }
            }

            if(lets.get(x).getY() >= 780) {
                lets.remove(x);
            }

            if(cities.size() == 0 || laser.polyGetBounds().intersects(lets.get(x).letterGetBounds())) {
                g.setColor(Color.RED);
                g.setFont(new Font("Monospaced", Font.BOLD, 30));
                g.drawString("Game Over!", 650, 350);
                game = false;
            }

            g.setColor(Color.RED);

            if(hit == (int) lets.get(x).getLetter()) {
                if(lets.get(x).isStrong()) {
                    if(lets.get(x).getLives() > 1 ) {
                        g.drawLine(745, 665, lets.get(x).getX(), lets.get(x).getY());
                        lets.get(x).setLives(1);
                    } else {
                        lets.get(x).setLives(1);
                        g.drawLine(745, 665, lets.get(x).getX(), lets.get(x).getY());
                        lets.remove(x);
                        score += 10;
                    }
                    hit = (int) '.';
                } else {
                    g.drawLine(745, 665, lets.get(x).getX(), lets.get(x).getY());
                    lets.remove(x);
                    score += 10;
                    hit = (int) '.';
                }
            }

            if(score == 1000) {
                g.setColor(Color.red);
                g.setFont(new Font("Monospaced", Font.BOLD, 30));
                g.drawString("You WIN!", 650, 350);
                game = false;
            }

        }

        g.setColor(Color.PINK);
        g.setFont(new Font("Monospaced", Font.BOLD, 30));
        g.drawString("Score: " + score, 40, 40);
        
        secondCount++;

    }


    public void createCities(int num) {
        cities.add(new City(20, 685));
        cities.add(new City(195, 685));
        cities.add(new City(370, 685));
        cities.add(new City(545, 685));
        cities.add(new City(845, 685));
        cities.add(new City(1020, 685));
        cities.add(new City(1195, 685));
        cities.add(new City(1370, 685));
    }

    public ArrayList<Letter> getLets() {
        return lets;
    }

    public void setLets(ArrayList<Letter> let) {
        lets = let;
    }
}