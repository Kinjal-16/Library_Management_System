package Options;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SUBMIT implements ActionListener
{
    JButton b;
    JTextField t1;
    JFrame f;
    SUBMIT()
    {
        f=new JFrame("SUBMIT A  BOOK");
        f.setLayout(null);
        JLabel l1=new JLabel();
        l1.setBounds(0,0,1280,600);
        JLabel l2=new JLabel("Enter the name of the book you want to submit");
        l2.setBounds(200,80,600,50);
        l2.setFont(new Font("serif",Font.BOLD,30));
        l1.add(l2);
        t1=new JTextField();
        t1.setBounds(200,150,600,60);
        l1.add(t1);
        f.setVisible(true);
        f.setSize(1280 ,600);
        f.setLocation(0,200);

        f.add(l1);
        b=new JButton("Submit");
        b.setBounds(200,400,100,60);
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


                        String str2 = "UPDATE BOOKS set NO_OF_COPIES=NO_OF_COPIES+1 WHERE NAME= '" + str1 + "'";
                        con.s.executeUpdate(str2);
                        JOptionPane.showMessageDialog(null, "THE BOOK IS SUBMITTED");
                        f.setVisible(false);
                        new SUBMIT();

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid name");
                    f.setVisible(false);
                    new SUBMIT();
                }



            }
            catch (Exception error){
                error.printStackTrace();
            }}}
    public static void main(String args[])
    {
        SUBMIT ob = new SUBMIT();
    }


}
