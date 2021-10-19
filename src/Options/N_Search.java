package Options;

import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
public class N_Search implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t;
    JButton b1,b2;
    JTable T;

    N_Search()
    {
        f = new JFrame("Searching for a book");
        f.setLayout(null);
        l1=new JLabel();
        l1.setBounds(0,0,1280,800);
        l2=new JLabel("Enter the name of the book you want to search:-");
        l2.setBounds(200,100,600,50);
        l2.setFont(new Font("serif",Font.BOLD,25));
        t=new JTextField();
        t.setBounds(200,300,600,50);
        b1=new JButton("Search");
        b2=new JButton("Exit");
        b1.setBounds(600,500,200,60);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b2.setBounds(600,600,200,60);
        l1.add(l2);
        l1.add(b1);
        l1.add(t);
        l1.add(b2);
        f.setVisible(true);
        f.setBounds(0,100,1280,600);
        f.add(l1);


    }
    public void actionPerformed(ActionEvent ae)
    {
        JFrame j2=new JFrame("Search successful");
        j2.setLayout(null);
        j2.setBounds(0,600,1920,200);
        DefaultTableModel T1=new DefaultTableModel();
        JTable T = new JTable();

        T1.addColumn("NAME");
        T1.addColumn("AUTHOR");
        T1.addColumn("PUBLISHER");
        T1.addColumn("EDITION");
        T1.addColumn("NO. OF COPIES");

        if(ae.getSource()==b1)
        {
            try {
                String ss = t.getText();

                String str = "SELECT * FROM BOOKS WHERE NAME ='" + ss + "'";
                Conn con = new Conn();
                ResultSet rs = con.s.executeQuery(str);
                if(rs.next())
                {
                    do
                    {
                        String name = rs.getString(1);
                        String author=rs.getString(2);
                        String pub=rs.getString(3);
                        String edi=rs.getString(4);
                        int no=rs.getInt(5);
                        T1.addRow(new Object[]{name,author,pub,edi,no});


                    }while(rs.next());
                    T.setModel(T1);
                    j2.getContentPane().add(new JScrollPane(T));

                    j2.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Sorry!Book not Found");
            }
            catch (Exception event)
            {
                event.printStackTrace();
            }

        }
    }
    public  static void main(String args[])
    {
        N_Search ob = new N_Search();
    }
}
