package ru.gb.homework.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weathervalues")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name="date")
    private String date;
    @Column(name="temperaturec")
    private int temperatureC;

    public int temperatureF() {
        return 32 + ((int)(this.temperatureC / 0.5556));
    }

}
