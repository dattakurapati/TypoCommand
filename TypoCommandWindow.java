import javax.swing.JFrame;

public class TypoCommandWindow extends JFrame {
    public TypoCommandWindow() throws InterruptedException {
        setSize(1500, 800);
        setTitle("TypoCommand - Kurapati");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        TypoCommand comm = new TypoCommand();

        add(comm);
        setVisible(true);
        
        while(comm.game) {
            //comm.move();
            comm.repaint();
            Thread.sleep(50);
        }

    }

}
