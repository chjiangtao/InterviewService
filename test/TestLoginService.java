import bean.WeatherEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.WeatherImpl;
import service.WeatherService;
import utils.JSONUtil;
import utils.WeatherUtil;

public class TestLoginService {

   public static void main(String[] args){
       ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
       WeatherService weatherService= (WeatherImpl) ac.getBean("weather");
//       WeatherUtil weatherUtil=new WeatherUtil();
//       String result=weatherUtil.getWeather("云阳");
//       JSONUtil json=new JSONUtil();
//       WeatherEntity weather=json.getWeather(result);
//       weatherService.saveWeather(weather);
       System.out.println(weatherService.getWeather("深圳市").toString());
   }
}
