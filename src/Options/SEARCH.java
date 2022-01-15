package Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SEARCH implements ActionListener{
    static JFrame f1,f2;
    static JLabel l1,l2;
    static JButton b1,b2;
    JTextField t;
    static JPanel p,p2;
    JComboBox List;
    String Name;
    SEARCH()
    {
        f1=new JFrame("Search for a book");
        f1.setLayout(null);
        l1=new JLabel("How would you like to search ?");
        l1.setForeground(Color.red);

        p = new JPanel();
        p.add(l1);

        p.setSize(800,600);
        String options[] ={"Book's name","Author's name"};
        Name = options[0];
        List = new JComboBox(options);

        p.add(List);
        List.addActionListener(this);
        b1=new JButton("Search");
        b1.addActionListener(this);
        f1.add(p);
        p.add(b1);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBounds(50,50,800,600);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==List) {
            JComboBox cb = (JComboBox) e.getSource();
            Name = (String) cb.getSelectedItem();

        }
        if(e.getSource()==b1)
        {
            if(Name.compareTo("Book's name")==0){N_Search ob = new N_Search(0);}
            if(Name.compareTo("Author's name")==0){N_Search ob = new N_Search(1);}
        }
        if(e.getSource()==b2)
        {
            System.out.println("Test");
        }

    }





    public static void main(String args[]){




        SEARCH ob = new SEARCH();




    }
}
