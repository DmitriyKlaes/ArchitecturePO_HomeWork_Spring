package ru.gb.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework.models.WeatherForecast;
import ru.gb.homework.models.WeatherForecastHolder;

@Controller
@RequiredArgsConstructor
public class WeatherForecastController {
    private final WeatherForecastHolder weatherForecastHolder;

    @GetMapping("/")
    public String weatherView(Model model) {
        model.addAttribute("values", weatherForecastHolder.getValues());
        return "weatherview";
    }

    @PostMapping("/value/add")
    public String addValue(WeatherForecast weatherForecast) {
        weatherForecastHolder.addNewValue(weatherForecast);
        return "redirect:/";
    }

    @PostMapping("/value/remove/{id}")
    public String removeValue(@PathVariable Integer id) {
        weatherForecastHolder.removeValue(id);
        return "redirect:/";
    }

    @PostMapping("/value/change/{id}")
    public String changeValue(@PathVariable Integer id, WeatherForecast weatherForecast) {
        WeatherForecast currentWeatherValue = weatherForecastHolder.getValueFromId(id);
        currentWeatherValue.setDate(weatherForecast.getDate());
        currentWeatherValue.setTemperatureC(weatherForecast.getTemperatureC());
        return "redirect:/";
    }
}
