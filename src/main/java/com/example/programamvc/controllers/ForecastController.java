package com.example.programamvc.controllers;

import com.example.programamvc.models.ForecastModel;
import com.example.programamvc.models.IndexModel;
import com.example.programamvc.models.Place;
import com.example.programamvc.models.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ForecastController {

    @GetMapping("/")
    public ModelAndView index() throws IOException {
        var modelAndView = new ModelAndView("index");
        var indexModel = new IndexModel();

        ArrayList<String> cities = getCities();
        indexModel.cities = cities;

        ArrayList<ForecastModel> forecasts = getForecasts();
        indexModel.forecasts = forecasts;

        modelAndView.addObject("IndexModel", indexModel);

        return modelAndView;
    }

    private static ArrayList<String> getCities() throws IOException {
        var cities = new ArrayList<String>();
        // cities.add("Vilnius");
        // cities.add("Kaunas");

        var jason = loadDataJson("https://api.meteo.lt/v1/places");

        ObjectMapper om = new ObjectMapper();
        Place[] places = om.readValue(jason, Place[].class);

        for (var place : places){
            cities.add(place.name);
        }

         return cities;
    }

    private static ArrayList<ForecastModel> getForecasts() throws IOException {
        var forecasts = new ArrayList<ForecastModel>();
        //   forecasts.add(new ForecastModel("2023-03-20",1));
        //   forecasts.add(new ForecastModel("2023-03-21",2));
        //  forecasts.add(new ForecastModel("2023-03-22",3));

        var jason = loadDataJson("https://api.meteo.lt/v1/places/vilnius/forecasts/long-term");
        ObjectMapper om = new ObjectMapper();
        Root obj = om.readValue(jason, Root.class);


        for (var stamp : obj.forecastTimestamps){
            var forecast = new ForecastModel(stamp.forecastTimeUtc, stamp.airTemperature);
            forecasts.add(forecast);
        }

        return forecasts;
    }


    private static String loadDataJson(String apiURL) throws IOException {
        URL url = new URL(apiURL);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        String text = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            text += scanner.nextLine();
        }
        scanner.close();
        return text;
    }


}