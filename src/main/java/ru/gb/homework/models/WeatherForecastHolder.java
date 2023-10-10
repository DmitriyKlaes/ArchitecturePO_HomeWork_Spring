package ru.gb.homework.models;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.homework.repositories.WeatherRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherForecastHolder {

    private final WeatherRepository weatherRepository;

    public List<WeatherForecast> getValues() {
        return weatherRepository.getValues();
    }

    public void addNewValue(WeatherForecast weatherForecast) {
        log.info("Saving new {}", weatherForecast);
        weatherRepository.save(weatherForecast);
    }

    public void removeValue(Integer id) {
        weatherRepository.deleteById(id);
    }

    public WeatherForecast getValueFromId(Integer id) {
        return weatherRepository.findById(id).orElse(null);
    }
}
