package conversor;
import javax.swing.JPanel;
import java.awt.*;

public class myJPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawRect(200,200,250,250);
        g.drawString("hola mundo",200,150);
    }

}
