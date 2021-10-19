package Options;
import java.sql.*;
public class Conn
{
    public  Connection c;
    public Statement s;
     Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","09042001");
            s=c.createStatement();
        }
        catch (Exception ae)
        {
            ae.printStackTrace();
        }
    }
    public static void main(String args[]){
            Conn ob=new Conn();
    }
}
