package Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class N_Student implements ActionListener {
    JFrame f;
    JLabel L1,L2,L3,L4,L5,L6,L7;
    JTextField T1,T2,T3,T4,T5,T6;
    JButton b1,b2;
    String a,b,c,d,e,g;
    N_Student()
    {
        L6 =new JLabel();
        L6.setBounds(100,40,800,600);
        f=new JFrame("Library Management System");
        f.setLayout(null);
        L1=new JLabel("Name of the Student");
        L1.setForeground(Color.YELLOW);
        L1.setBounds(100,50,300,25);
        L1.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L1);


        T1=new JTextField();
        T1.setBounds(100,75,350,20);
        L6.add(T1);


        L2=new JLabel("Roll no.");
        L2.setForeground(Color.YELLOW);
        L2.setBounds(100,120,300,25);
        L2.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L2);

        T2=new JTextField();
        T2.setBounds(100,145,350,20);
        L6.add(T2);

        L3=new JLabel("Subject");
        L3.setForeground(Color.YELLOW);
        L3.setBounds(100,190,300,25);
        L3.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L3);

        T3=new JTextField();
        T3.setBounds(100,215,350,20);
        L6.add(T3);

        L4=new JLabel("Year of study");
        L4.setForeground(Color.YELLOW);
        L4.setBounds(100,260,300,25);
        L4.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L4);

        T4=new JTextField();
        T4.setBounds(100,285,350,20);
        L6.add(T4);

        L5=new JLabel("Book1");
        L5.setForeground(Color.YELLOW);
        L5.setBounds(100,330,350,20);
        L5.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L5);




        T5=new JTextField();
        T5.setBounds(200,400,350,20);
        L6.add(T5);

        L7=new JLabel("Book2");
        L7.setForeground(Color.YELLOW);
        L7.setBounds(100,400,350,20);
        L7.setFont(new Font("serif",Font.BOLD,25));
        L6.add(L7);

        T6=new JTextField();
        T6.setBounds(100,420,350,20);
        L6.add(T6);

        b1=new JButton("ADD DETAILS");
        b1.setBounds(100,500,200,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        L6.add(b1);

        b2=new JButton("EXIT");
        b2.setBounds(100,550,200,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        L6.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel L7 = new JLabel(i3);
        L7.setBounds(15, 0, 800, 600);
        L6.add(L7);


        f.add(T5);
        f.setVisible(true);
        f.setSize(800 ,600);
        f.setLocation(50,50);

        f.add(L6);






    }
    public String textBlocks() {
        return """
CREATE TABLE IF NOT EXISTS STUDENTS (
	Name varchar(255),
    RollNo varchar(255),
    Subject varchar(255),
    Year_of_study varchar(255),
    Book1 varchar(255),
    Book2 varchar(255)
);""";
    }
    public void actionPerformed(ActionEvent ae){





        if(ae.getSource()==b1) {
            try {
                a = T1.getText();
                b = T2.getText();
                c = T3.getText();
                d = T4.getText();
                e = T5.getText();
                g = T6.getText();
                if(a.equals(""))
                    a="None";
                if(b.equals(""))
                    b="None";
                if(c.equals(""))
                    c="None";
                if(d.equals(""))
                    d="None";
                if(e.equals(""))
                    e="None";
                if(g.equals(""))
                    g="None";

                Conn cc = new Conn();
                String s = textBlocks();
                cc.s.executeUpdate(s);
                String ss = "INSERT INTO STUDENTS VALUES('" + a + "','" + b + "','" + c + "','" + d + "','"+e+"','"+g+"');";
                cc.s.executeUpdate(ss);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                f.setVisible(false);
                new Buttons();
            } catch (Exception error) {
                error.printStackTrace();
            }


        }
        else
        {
            f.setVisible(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public  static void main(String[ ] arg){
        new N_Student();
    }

}
