package bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weather", schema = "interview", catalog = "")
public class WeatherEntity {
    private int id;
    private String city;
    private String weather;
    private String temperature;
    private String winddirection;
    private String windpower;
    private String reporttime;

    public WeatherEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "weather", nullable = true, length = 255)
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Basic
    @Column(name = "temperature", nullable = true, length = 255)
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "winddirection", nullable = true, length = 255)
    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    @Basic
    @Column(name = "windpower", nullable = true, length = 255)
    public String getWindpower() {
        return windpower;
    }

    public void setWindpower(String windpower) {
        this.windpower = windpower;
    }

    @Basic
    @Column(name = "reporttime", nullable = true, length = 255)
    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity that = (WeatherEntity) o;
        return id == that.id &&
                Objects.equals(city, that.city) &&
                Objects.equals(weather, that.weather) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(winddirection, that.winddirection) &&
                Objects.equals(windpower, that.windpower) &&
                Objects.equals(reporttime, that.reporttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, weather, temperature, winddirection, windpower, reporttime);
    }
}
