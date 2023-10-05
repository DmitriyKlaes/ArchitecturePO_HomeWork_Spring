package ru.gb.homework.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherForecast {

    private Integer id;
    private String date;
    private int temperatureC;

    public int temperatureF() {
        return 32 + ((int)(this.temperatureC / 0.5556));
    }

}
