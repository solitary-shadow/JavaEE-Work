import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        DBOper db = new DBOper();
//        db.getConn(server, dbname, dbuser, dbpwd);
//        String sql = "SELECT username,userpass,role FROM tb_user WHERE username = ? AND userpass = ?";
////        ResultSet rs = db.executeQuery(sql,new String[]{username,userpass});
        UserDao userDao = new UserDao();
        UserT user = new UserT();

        try {

            user = userDao.SelectUserByName(username,password);

            if(user.getUserName() != null && user.getPassword() != null ){
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String logtime = sdf.format(new Date());
                session.setAttribute("logtime",logtime);
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request,response);
                System.out.println("登录成功"+user.getUserName()+","+user.getPassword());
            }else{
                System.out.println("登录失败"+user.getUserName()+","+user.getPassword());
                out.print("登录失败");
                out.print("<br><a href = 'login.jsp'>重新登陆</a>");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
