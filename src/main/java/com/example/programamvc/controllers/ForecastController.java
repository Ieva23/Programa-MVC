package com.example.programamvc.controllers;

import com.example.programamvc.models.ForecastModel;
import com.example.programamvc.models.IndexModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ForecastController {

    @GetMapping("/")
    public ModelAndView index() {
        var modelAndView = new ModelAndView("index");
        var indexModel = new IndexModel();

        ArrayList<String> cities = getCities();
        indexModel.cities = cities;

        ArrayList<ForecastModel> forecasts = getForecasts();
        indexModel.forecasts = forecasts;

        modelAndView.addObject("IndexModel", indexModel);

        return  modelAndView;
    }

    private static ArrayList<String> getCities() {
        var cities = new ArrayList<String>();
        cities.add("Vilnius");
        cities.add("Kaunas");
        return cities;
    }

    private static ArrayList<ForecastModel> getForecasts() {
        var forecasts = new ArrayList<ForecastModel>();
        forecasts.add(new ForecastModel("2023-03-20",1));
        forecasts.add(new ForecastModel("2023-03-21",2));
        forecasts.add(new ForecastModel("2023-03-22",3));
        return forecasts;
    }

}
