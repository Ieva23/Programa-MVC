package com.example.programamvc.controllers;

import com.example.programamvc.models.Forecast;
import com.example.programamvc.models.ForecastModel;
import com.example.programamvc.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ForecastRestController {

    @Autowired
    private ForecastRepository forecastRepository;

    @PostMapping(value ="/api/forecast", consumes = "application/json")
    public void index(@RequestBody ForecastModel model){
        Forecast entity = new Forecast(
                model.date,
                String.valueOf(model.temperature),
                "Vilnius",
        1);

        forecastRepository.save(entity);


    }

}
