package Options;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class S_List
{
    JFrame f;
    JTable t;
    S_List() throws SQLException {
        f=new JFrame("Student List");
        String S = "SELECT * FROM STUDENTS";
        Conn c = new Conn();
        ResultSet r = c.s.executeQuery("SELECT COUNT(*) FROM STUDENTS");
        r.next();
        int len = r.getInt("count(*)");
        ResultSet data = c.s.executeQuery(S);
        String str[][] = new String[len][6];
        int row=0;
        while(data.next()){


            str[row][0] = data.getString(1);
            str[row][1] = data.getString(2);
            str[row][2] = data.getString(3);
            str[row][3] = data.getString(4);
            str[row][4] = data.getString(5);
            str[row][5] = data.getString(6);
            row++;

        }

        String colNames[]={"Name","Roll. No.","Subject","Year of study","Book 1","Book 2"};

        t = new JTable(str, colNames);
        t.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(t);
        f.add(sp);


        f.setSize(500, 200);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    public static void main(String args[]) throws SQLException {
        new S_List();
    }
}
