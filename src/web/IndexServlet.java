package web;

import entity.RainQuality;
import service.RainManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: laoyu
 * @Date: 2020/2/18 17:43
 * @Description:
 */
@WebServlet(name = "IndexServlet",urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet调用service层的数据
        RainManagerService service = new RainManagerService();
        List<RainQuality> allInfo = service.getAllInfo();
        //把数据存储到request作用域（a-b）
        request.setAttribute("allinfo",allInfo);
        //跳转页面
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
