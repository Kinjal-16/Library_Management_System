package Options;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SUBMIT implements ActionListener
{
    JButton b;
    JTextField t1,t2;
    JFrame f;
    int c=0;
    SUBMIT()
    {
        f=new JFrame("SUBMIT A  BOOK");
        f.setLayout(null);
        JLabel l1=new JLabel();
        l1.setBounds(0,0,1280,600);
        JLabel l2=new JLabel("Enter the name of the book you want to submit");
        l2.setBounds(200,80,600,50);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l2);
        t1=new JTextField();
        t1.setBounds(200,130,600,30);
        l1.add(t1);

        JLabel l3=new JLabel("Enter the student's name");
        l3.setBounds(200,200,600,50);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l3);
        t2=new JTextField();
        t2.setBounds(200,250,600,30);
        l1.add(t2);
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
                Conn con2 = new Conn();
                Conn con3 = new Conn();
                String str1 = t1.getText();
                String str3 = t2.getText();
                ResultSet rs = con.s.executeQuery("SELECT * FROM BOOKS where NAME = '" + str1 + "'");
                ResultSet rs2 = con2.s.executeQuery("SELECT * FROM Issue_time where Student_name = '" + str3 + "'");
                int flag = 0;
                while (rs2.next()) {
                    String str = rs2.getString(2);

                    if (str.compareTo(str1) == 0) {
                        flag = 1;
                        c++;
                        break;

                    }
                }

                if (flag == 1) {
                    if (rs.next()) {
                        String time=rs2.getString(3);
                        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                        Date date1=formatter.parse(time);
                        LocalDate temp= LocalDate.now();
                        Date date2 = java.util.Date.from(temp.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                        long difference=(date2.getTime()-date1.getTime());
                        TimeUnit unit = TimeUnit.DAYS;
                        long  diff= unit.convert(difference, TimeUnit.MILLISECONDS);
                        


                        String str5="DELETE FROM Issue_time WHERE Student_name='"+str3+"'"+"AND Book_name ='"+str1+"'";
                        con2.s.executeUpdate(str5);
                        if(c==1)
                        {
                            String str6="UPDATE STUDENTS SET Book1 ='"+"None'"+" WHERE Name='"+str3+"'"+"AND Book1 ='"+str1+"'";
                            con3.s.executeUpdate(str6);
                        }
                        else
                        {
                            String str6="UPDATE STUDENTS SET Book2 ='"+"None'"+" WHERE Name='"+str3+"'"+"AND Book2 ='"+str1+"'";
                            con3.s.executeUpdate(str6);
                        }
                        String str2 = "UPDATE BOOKS set NO_OF_COPIES=NO_OF_COPIES+1 WHERE NAME= '" + str1 + "'";
                        con.s.executeUpdate(str2);

                        if(diff>30) {
                            int fine = (int)(2*(diff-30));
                            JOptionPane.showMessageDialog(null, "THE BOOK IS SUBMITTED." +
                                    "\nFINE TO BE PAID: "+String.valueOf(fine)+" EUROs");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "THE BOOK IS SUBMITTED WITHOUT ANY FINE");
                        f.setVisible(false);
                        new SUBMIT();

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid name");
                        f.setVisible(false);
                        new SUBMIT();
                    }


                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Name mismatch. Please enter again");
                    f.setVisible(false);
                    new SUBMIT();
                }
            }
            catch (Exception error){
                error.printStackTrace();
            }}}
    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
    public static void main(String args[])
    {
        new SUBMIT();
    }


}
