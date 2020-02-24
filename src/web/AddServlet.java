package web;

import com.sun.org.apache.xpath.internal.operations.String;
import entity.RainQuality;
import service.RainManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: laoyu
 * @Date: 2020/2/20 16:19
 * @Description:
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //调用service层新增雨量信息的方法
        RainManagerService rainManagerService = new RainManagerService();

        //获取参数
        java.lang.String districtName = request.getParameter("districtName");
        java.lang.String monitorTime = request.getParameter("monitorTime");
        int rainNum = Integer.valueOf(request.getParameter("rain"));
        java.lang.String monitoringStation = request.getParameter("monitoringStation");
        java.lang.String monitoringAddress = request.getParameter("monitoringAddress");

        //把参数封装到对象中
        RainQuality rain = new RainQuality();
        //String转换为Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date date = sdf.parse(monitorTime);
            rain.setMonitorTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        rain.setMonitoringAddress(monitoringAddress);
        rain.setMonitoringStation(monitoringStation);
        rain.setDistrictName(districtName);
        rain.setRain(rainNum);

        //执行添加的方法
        int i = rainManagerService.addNewRainInfo(rain);
        if (i == 1) {
            System.out.println("ok");
            //跳转页面
            request.getRequestDispatcher("index").forward(request, response);
        } else {
            System.out.println("error");
            response.sendRedirect("add.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
