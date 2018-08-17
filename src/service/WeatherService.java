package service;

import bean.WeatherEntity;

public interface WeatherService {
    //获取一个城市的天气
    WeatherEntity getWeather(String city);
    //保存一个城市的天气
    void saveWeather(WeatherEntity weather);
    //删除一个城市的天气
    void deleteWeather(String city);
    //更新城市的天气
    void updateWeather(WeatherEntity weather);
}
