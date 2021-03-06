import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/StudentRegister")
public class MyServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        super.doGet(req, resp);
//        resp.getWriter().write("hello,world");
//    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out =response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        U user = new U();
//        user.setUsername(username);
//        user.setPassword(password);
//        System.out.println("23232323");
//        UserDao u =new UserDao();
        HttpSession session =request.getSession();

        UserT user = new UserT();
        user.setPassword(password);
        user.setUserName(username);

        session.setAttribute("UserName",username);
        session.setAttribute("UserPassword",password);
        session.setAttribute("message","你注册成功了");

        UserDao userDao = new UserDao();
        try {
            if(userDao.insertUser(user.getUserName(),user.getPassword())){
                System.out.println("注册成功");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                System.out.println("注册失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
