package com.example.programamvc.controllers;

import com.example.programamvc.models.ForecastModel;
import org.springframework.web.bind.annotation.*;


@RestController
public class ForecastRestController {
    @PostMapping(value ="/api/forecast", consumes = "application/json")
    public void index(@RequestBody ForecastModel model){

    }

}
