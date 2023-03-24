package com.example.programamvc.repositories;

import com.example.programamvc.models.Forecast;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

}