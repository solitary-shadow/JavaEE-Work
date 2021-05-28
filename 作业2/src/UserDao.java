import java.sql.SQLException;

public class UserDao {

    boolean insertUser(String username, String password) throws SQLException {
        boolean isSuccess;
        try{
            isSuccess = DbUtil.insertUser(username, password);
        }catch (Exception e){
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

    UserT SelectUserByName(String username,String password) throws SQLException {
        return DbUtil.UserLogin(username, password);
    }

}
