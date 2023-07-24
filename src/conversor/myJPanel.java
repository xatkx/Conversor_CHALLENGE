package conversor;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

public class myJPanel extends JPanel implements KeyListener {

    Rectangle2D jugador = new Rectangle2D.Double();
    Ellipse2D ball = new Ellipse2D.Double();

    //controller
    boolean left = false;
    boolean right = false;
    // player
    int positionPlayerX = 0;
    int positionPlayerY = 0;
    int widPlayer;
    int heiPlayer;
    int speedP = 10;

    // ball
    int ballSpeedX;
    int ballSpeedY;
    int ballX;
    int ballY;
    int widBall;
    int heiBall;

    // sett
    Timer loop;
    int widScreen;
    int heiScreen;

    public myJPanel (){

        screen screen = new screen();

        widScreen = screen.width/3;
        heiScreen = screen.height/2;

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        setGame();
        this.perfectLoop(10);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        jugador.setFrame(positionPlayerX,positionPlayerY,widPlayer,heiPlayer);
        ball.setFrame(ballX,ballY,widBall,heiBall);

        g2d.draw(jugador);
        g2d.draw(ball);
    }

    private void setGame(){
        ballX = (widScreen /3);
        ballY=20;
        widBall = 50;
        heiBall = widBall;
        ballSpeedX = 5;
        ballSpeedY = 5;

        heiPlayer = 30;
        widPlayer = 100;
        positionPlayerX = widScreen/2-50;
        positionPlayerY = heiScreen - 100;

    }

    private void perfectLoop(int delay){
        this.loop = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // colicion x.x
                    // jugador
                if(
                        positionPlayerX < ballX &&
                        positionPlayerX + widPlayer > ballX &&
                        positionPlayerY < ballY + widBall

                )
                {
                    ballSpeedY = - ballSpeedY;
                }
                    // paredes
                if(ballX >= widScreen - widBall|| ballX <= 0)
                {
                    ballSpeedX = -ballSpeedX;
                }
                if(ballY + widBall >= heiScreen - widBall || ballY <= 0)
                {
                    ballSpeedY = -ballSpeedY;
                }

                // move player

                if(left && positionPlayerX > 0)
                {
                    positionPlayerX -= speedP;
                }
                if(right && positionPlayerX + widPlayer < widScreen){
                    positionPlayerX += speedP;
                }

                ballX += ballSpeedX;
                ballY += ballSpeedY;
                repaint();

            }
        });
        loop.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;

        }
    }
}
