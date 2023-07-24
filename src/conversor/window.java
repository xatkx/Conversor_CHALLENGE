package conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class window extends JFrame implements ActionListener {

    private final String TITLE = "Conversor";

    JPanel navegadorContainer;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem menuItem1;
    JMenuItem menuItem2;
    JMenuItem menuItem3;

    int width;
    int height;
    public window(){

        screen screen = new screen();
        width = screen.width;
        height = screen.height;

        this.setTitle(TITLE);
        this.setSize(width/3,height/2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        navegadorContainer = new myJPanel();
        navegadorContainer.add(menuInit());
        this.add(navegadorContainer);
    }

    public JMenuBar menuInit(){
        menubar = new JMenuBar();
        menu = new JMenu();
        menu.setSize(100,45);
        menu.setText("MENU");
        menu.setLocation(10,5);

        menuItem1 = new JMenuItem();
        menuItem1.setText("Conversor de Divisas");
        menuItem1.addActionListener(this);

        menuItem2 = new JMenuItem();
        menuItem2.setText("Conversor de temperatura");
        menuItem2.addActionListener(this);

        menuItem3 = new JMenuItem();
        menuItem3.setText("Conversor de algo");
        menuItem3.addActionListener(this);

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menubar.add(menu);

        return menubar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
