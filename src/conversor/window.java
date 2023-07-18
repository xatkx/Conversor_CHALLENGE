package conversor;

import javax.swing.*;
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

    public window(){

        this.setTitle(TITLE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        navegadorContainer = new JPanel();

        navegadorContainer.add(menuInit());


        this.add(navegadorContainer);
    }

    public JMenuBar menuInit(){
        menubar = new JMenuBar();
        menu = new JMenu();
        menu.setSize(100,45);
        menu.setText("MENU");

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
