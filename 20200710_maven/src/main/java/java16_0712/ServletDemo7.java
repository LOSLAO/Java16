package java16_0712;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先构造Cookie对象 每个Cookie对象就是一个键值对
        Cookie userName = new Cookie("userName", "LA");
        Cookie age = new Cookie("age", 18 + "");
        //2.把cookie放到响应中
        resp.addCookie(userName);
        resp.addCookie(age);
        //3.创建一个相应报文
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("返回cookie成功!");
    }
}
