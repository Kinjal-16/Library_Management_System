package Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SEARCH implements ActionListener {
    JFrame f1;
    JLabel l1;
    JButton b1,b2;
    SEARCH()
    {
        f1=new JFrame("Search for a book");
        f1.setLayout(null);
        l1= new JLabel("Choose one of the following option for Searching  :-");
        l1.setBounds(200,100,600,100);
        l1.setFont(new Font("serif",Font.BOLD,25));
        b1=new JButton("Name of the book");
        b2=new JButton("Name of the Author");
        b1.setFont(new Font("serif",Font.BOLD,20));
        b2.setFont(new Font("serif",Font.BOLD,20));
        b1.setBounds(200,200,500,100);
        b2.setBounds(200,400,500,100);
        f1.add(b1);
        f1.add(b2);
        f1.add(l1);
        f1.setVisible(true);
        f1.setBounds(50,50,800,600);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==b1)
        {

        }
        else if(ae.getSource()==b2)
        {

        }
    }
    public static void main(String args[]){
        SEARCH OB=new SEARCH();
    }
}
