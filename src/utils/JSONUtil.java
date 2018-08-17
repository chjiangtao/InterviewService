package utils;

import bean.WeatherEntity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * JSON数据解析
 */
public class JSONUtil {

    public WeatherEntity getWeather(String result){
        WeatherEntity WeatherEntity = null;
        JsonParser parser=new JsonParser();
        JsonObject object= (JsonObject) parser.parse(result);
        JsonArray array=object.get("lives").getAsJsonArray();
        for(int i=0;i<array.size();i++){
           WeatherEntity=new WeatherEntity();
           JsonObject subObject=array.get(i).getAsJsonObject();
           WeatherEntity.setCity(subObject.get("city").getAsString());
           WeatherEntity.setWeather(subObject.get("weather").getAsString());
           WeatherEntity.setWinddirection(subObject.get("winddirection").getAsString());
           WeatherEntity.setWindpower(subObject.get("windpower").getAsString());
           WeatherEntity.setTemperature(subObject.get("temperature").getAsString());
           WeatherEntity.setReporttime(subObject.get("reporttime").getAsString());
        }
        return WeatherEntity;
    }

    /**
     * 天气数据转换成JSON
     * @param weather
     * @return
     */
    public String getWeatherJSON(WeatherEntity weather){
        Gson gson=new Gson();
        String result=gson.toJson(weather);
        return result;
    }
}
