package Options;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ISSUE implements ActionListener
{
    JButton b;
    JTextField t1,t2;
    JFrame f;
    String b1,b2,str3,str,str1;
    ISSUE()
    {
        f=new JFrame("ISSUE A NEW BOOK");
        f.setLayout(null);
        JLabel l1=new JLabel();
        l1.setBounds(50,50,800,600);
        JLabel l2=new JLabel("Name of the book: -");
        l2.setBounds(50,30,400,100);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l2);
        t1=new JTextField();
        t1.setBounds(50,100,400,30);
        l1.add(t1);
        JLabel l3=new JLabel("Name of the Student: -");
        l3.setBounds(50,140,400,100);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l3);
        t2=new JTextField();
        t2.setBounds(50,210,400,30);
        l1.add(t2);
        f.setVisible(true);
        f.setSize(800 ,600);
        f.setLocation(50,50);

        f.add(l1);
        b=new JButton("Submit");
        b.setBounds(300,400,100,60);
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
            Conn con2 = new Conn();
            str1 = t1.getText();
            str = t2.getText();
            ResultSet rs  = con.s.executeQuery("SELECT * FROM BOOKS where NAME = '"+str1+"'");
            ResultSet r  = con2.s.executeQuery("SELECT * FROM STUDENTS where NAME = '"+str+"'");

            if(rs.next() && r.next()) {
                b1 = r.getString(5);

                b2 = r.getString(6);
                if (((b1.compareTo("None") != 0) && (b2.compareTo("None") != 0))) {
                    JOptionPane.showMessageDialog(null, "Student has already issued two books");

                } else {
                    int n = rs.getInt(5);
                    if (n != 0) {
                        if(b1.compareTo("None")==0){
                            str3 = "UPDATE STUDENTS set Book1='"+str1+"'"+" WHERE NAME= '" + str + "'";
                            con2.s.executeUpdate(str3);
                        }
                        else
                        {
                            str3 = "UPDATE STUDENTS set Book2='"+str1+"'"+" WHERE NAME= '" + str + "'";
                        }
                        String str2 = "UPDATE BOOKS set NO_OF_COPIES=NO_OF_COPIES-1 WHERE NAME= '" + str1 + "'";
                        con.s.executeUpdate(str2);
                        Time_of_issue();
                        JOptionPane.showMessageDialog(null, "The book is ready to be Published");
                        f.setVisible(false);

                        new ISSUE();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry! All copies of the book are issued");
                        f.setVisible(false);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid student's name ot Book's name");

                new ISSUE();
            }



        }
        catch (Exception error){
            error.printStackTrace();
        }}}
    void Time_of_issue() throws SQLException {
        String str = """
CREATE TABLE IF NOT EXISTS Issue_time (
	Student_name varchar(255),
    Book_name varchar(255),
    Time_of_issue varchar(255)
);""";
        Conn temp = new Conn();
        temp.s.executeUpdate(str);
        LocalDate date= LocalDate.now();
        str="INSERT INTO Issue_time VALUES('" + this.str + "','" + str1 + "','" + date + "');";
        temp.s.executeUpdate(str);


    }
    public static void main(String args[])
    {
        ISSUE ob = new ISSUE();
    }


}
