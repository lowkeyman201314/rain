package web;

import service.RainManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: laoyu
 * @Date: 2020/2/24 11:17
 * @Description:
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/del"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //实例化service对象
        RainManagerService service = new RainManagerService();
        //从表单的name属性获取雨量信息的编号
        String id = request.getParameter("rId");
        int i = service.deleteById(id);
        boolean flag = false;
        if (i == 1) {
            flag = true;
        } else {
            flag = false;
        }
        //把flag打印到页面，作为回调函数data处理的内容
        PrintWriter out = response.getWriter();
        out.print(flag);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
