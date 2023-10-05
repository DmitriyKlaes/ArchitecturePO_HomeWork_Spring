package ru.gb.homework.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherForecastHolder {

    private final List<WeatherForecast> values = new ArrayList<>();
    private int id = 0;

    public List<WeatherForecast> getValues() {
        return this.values;
    }

    public void addNewValue(WeatherForecast weatherForecast) {
        weatherForecast.setId(++id);
        this.values.add(weatherForecast);
    }

    public void removeValue(Integer id) {
        this.values.removeIf(value -> value.getId().equals(id));
    }

    public WeatherForecast getValueFromId(Integer id) {
        for (WeatherForecast value : this.values) {
            if (value.getId().equals(id)) {
                return value;
            }
        }
        return null;
    }
}
