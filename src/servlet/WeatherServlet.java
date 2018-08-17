package servlet;

import bean.WeatherEntity;
import service.WeatherImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取天气
 */
@WebServlet(name = "WeatherServlet")
public class WeatherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String city=request.getParameter("city");
        //先到数据库里查询是否已经有目标城市的天气
        WeatherImpl weatherImpl=new WeatherImpl();
        WeatherEntity weather=weatherImpl.getWeather(city);
        String result=null;
//        JSONUtil jsonUtil=new JSONUtil();
//        if(weather==null){//数据库里没有该城市的天气，就去高德获取
//            WeatherUtil weatherUtil=new WeatherUtil();
//
//            result=weatherUtil.getWeather(city);
//            weather=jsonUtil.getWeather(result);
//            weatherImpl.saveWeather(weather);
//        }
//        String weatherJSON=jsonUtil.getWeatherJSON(weather);
//        PrintWriter writer=response.getWriter();
//        writer.write(weatherJSON);
//        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
