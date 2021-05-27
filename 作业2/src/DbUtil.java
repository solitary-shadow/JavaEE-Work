import java.sql.*;
import java.util.ArrayList;

public class DbUtil {
    public static boolean insertUser(String u,String p) throws SQLException {
        ArrayList users=new ArrayList();
        PreparedStatement preparedStatement = null;
        Connection con = null;
        //启动mysql驱动器
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://47.101.213.60:3306/csharpfinal?useUnicode=true&characterEncoding=utf-8", "xiehang", "Cflolwdza123.");
            preparedStatement = con.prepareStatement("insert into usert values(?,?)");
            preparedStatement.setString(1,u);
            preparedStatement.setString(2,p);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            if(con!=null) {
                con.close();
            }
            if(preparedStatement!=null) {
                preparedStatement.close();
            }
        }
        return true;
    }

}
