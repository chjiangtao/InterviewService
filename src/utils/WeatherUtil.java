package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherUtil {
    private static final String KEY="148bd6834b01cd8594dc609fed7585d4";
    private String path="https://restapi.amap.com/v3/weather/weatherInfo?";

    public String getWeather(String city){
        StringBuffer result=new StringBuffer();
        try {
            URL url=new URL(path+"city="+city+"&key="+KEY);
            URLConnection conn=url.openConnection();
            BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
              result.append(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
