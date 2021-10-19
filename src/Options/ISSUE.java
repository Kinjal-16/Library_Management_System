package Options;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ISSUE implements ActionListener
{
    JButton b;
    JTextField t1;
    JFrame f;
    ISSUE()
    {
        f=new JFrame("ISSUE A NEW BOOK");
        f.setLayout(null);
        JLabel l1=new JLabel();
        l1.setBounds(50,50,800,600);
        JLabel l2=new JLabel("Name of the book you want to issue");
        l2.setBounds(250,100,400,100);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l2);
         t1=new JTextField();
        t1.setBounds(250,200,400,30);
        l1.add(t1);
        f.setVisible(true);
        f.setSize(800 ,600);
        f.setLocation(50,50);

        f.add(l1);
         b=new JButton("Submit");
        b.setBounds(300,300,100,60);
        f.add(b);
        b.addActionListener(this);

        f.setVisible(true);



    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b)
        {
        try {
            Conn con = new Conn();
            String str1 = t1.getText();

            ResultSet rs  = con.s.executeQuery("SELECT * FROM BOOKS where NAME = '"+str1+"'");
            if(rs.next())
            {
                int n=rs.getInt(5);
                if (n!=0) {
                    String str2 = "UPDATE BOOKS set NO_OF_COPIES=NO_OF_COPIES-1 WHERE NAME= '" + str1 + "'";
                    con.s.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null, "The book is ready to be Published");
                    f.setVisible(false);
                    new ISSUE();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sorry! All copies of the book are issued");
                    f.setVisible(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid name");

                new ISSUE();
            }



        }
        catch (Exception error){
            error.printStackTrace();
        }}}
    public static void main(String args[])
    {
        ISSUE ob = new ISSUE();
    }


}
