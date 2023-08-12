package conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import logic.Convert;


public class window extends JFrame implements ActionListener, ItemListener {

    private final String TITLE = "Conversor";

    Convert logic;
    JPanel navegadorContainer;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem menuItem1;
    JMenuItem menuItem2;
    JMenuItem menuItem3;
    
    JButton btn;
    JLabel result;
    JTextField coin;
    JComboBox<String> inputSelect;
    JComboBox<String> inputSelect2;
    ArrayList<String> selectitems = new ArrayList<>();
    
    

    int width;
    int height;
    public window(Convert convert){

        logic = convert;
        
        screen screen = new screen();
        width = screen.width;
        height = screen.height;

        this.setTitle(TITLE);
        this.setSize(width/3,height/2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        navegadorContainer = new myJPanel();       
        navegadorContainer.setLayout(null);
        
        setSelectInit(logic.getList());
        
        //navegadorContainer.add(setSelectInit(list));
        
        this.add(navegadorContainer);
        
        
    }
    
    private void setSelectInit(String[] list){

        int y = 100;
        int x = 40;
        int w = 80;
        int h = 20;
        
        btn = new JButton("Enter");
        inputSelect = new JComboBox<String>(list);
        inputSelect2 = new JComboBox<String>(list);
        coin = new JTextField();
        result = new JLabel();
        
        
        btn.addActionListener(this);
        inputSelect.addItemListener(this);
        inputSelect2.addItemListener(this);
        
        result.setText("");
        
        
        inputSelect.setBounds(x, y,w,h);
        coin.setBounds(x+w+20, y, w,h );
        inputSelect2.setBounds(x+w+w+40, y,w,h);
        result.setBounds(x+w*3+60,y,w,h);
        btn.setBounds(x*3+60,y*2,w,h);
        
        navegadorContainer.add(inputSelect);
        navegadorContainer.add(coin);
        navegadorContainer.add(inputSelect2);
        navegadorContainer.add(result);
        navegadorContainer.add(btn);
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
        //
        //System.err.println(menuItem1.equals(e.getSource()));
        
        if(e.getSource() == btn)
        {
             double c = 0;
             
            if(!coin.getText().isEmpty())
            {
              
               c = Double.parseDouble(coin.getText());
            }

            double total = 0;
            
            String s1 = "";
            String s2 = "";
            
            s1 = (String) inputSelect.getSelectedItem();
            s2 = (String) inputSelect2.getSelectedItem();
            
            total = logic.conversor(c, s1, s2);
            
            
            result.setText(String.valueOf(total));
            
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getSource() == inputSelect)
        {
            System.out.println(inputSelect.getSelectedItem());
        }else if(e.getSource() == inputSelect2)
        {
            System.out.println("segundo");
        }
    }

}
