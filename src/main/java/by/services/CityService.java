package by.services;

import by.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAll();
    City get(Long id);
    void create(City city);
    void update(City city);
    void delete(Long id);
    List<City> getByName(String name);
}
