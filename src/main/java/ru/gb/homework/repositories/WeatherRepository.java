package ru.gb.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework.models.WeatherForecast;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherForecast, Integer> {
    List<WeatherForecast> getValues();
}
