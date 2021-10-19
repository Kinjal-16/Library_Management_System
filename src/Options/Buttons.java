package Options;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class Buttons implements ActionListener {
    JFrame f;//Object of JFrame class
    JLabel l1, l2;
    JButton b1, b2, b3, b4,b5;
     Buttons() {
         f = new JFrame("Library Management System");
         f.setBackground(Color.BLUE);
         f.setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1280, 600, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         //l1 = new JLabel(i3);
         //l1.setBounds(0, 50, 1280, 600);
         //f.add(l1);
        JLabel Topic=new JLabel("LIBRARY MANAGEMENT SYSTEM");
        Topic.setBounds(500,0,500,80);
        Topic.setFont(new Font("serif",Font.BOLD,25));
        Topic.setForeground(Color.yellow);
         b1 = new JButton("SEARCH FOR A BOOK");
         b2 = new JButton("ISSUE A NEW BOOK");
         b3 = new JButton("SUBMIT A BOOK");
         b5= new JButton("ENTRY FOR A NEW BOOK");
         b4 = new JButton("EXIT");
         b1.setForeground(Color.BLACK);
         b2.setForeground(Color.BLACK);
         b3.setForeground(Color.BLACK);
         b4.setForeground(Color.BLACK);
         b5.setForeground(Color.BLACK);
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);
         b1.setBounds(500,100,200,20);
         b2.setBounds(500,200,200,20);
         b3.setBounds(700,100,200,20);
         b4.setBounds(700,450,200,20);
         b5.setBounds(700,200,200,20);
         JLabel id = new JLabel(i3);
         id.setBounds(0, 0, 1280   , 600);
         id.setLayout(null);

         id.add(b1);
         id.add(b2);
         id.add(b3);
         id.add(b4);
         id.add(b5);
         id.add(Topic);

         f.add(id);
         f.setVisible(true);
         f.setSize(1280, 600);
         f.setLocation(50, 50);
         f.getContentPane().setBackground(Color.BLACK);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


     }


      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new N_Search();
            f.setVisible(false);
        }


        if (ae.getSource() == b2) {
            new ISSUE();
            f.setVisible(false);
        }


        if (ae.getSource() == b3) {
            new SUBMIT();
            f.setVisible(false);
        }


        if (ae.getSource() == b4) {
            f.setVisible(false);
        }
          if (ae.getSource() == b5) {
              f.setVisible(false);
              new New_Entry();
          }
    }
    public static void main(String[] arg){
        Buttons f = new Buttons();
    }
}












