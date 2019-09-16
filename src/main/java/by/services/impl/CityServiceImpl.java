package by.services.impl;

import by.dao.CityDAO;
import by.entity.City;
import by.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityDAO cityDAO;

    @Transactional
    public void create(City city) {
        cityDAO.create(city);
    }

    @Transactional
    public City get(Long id) {
        City city;
        city = cityDAO.get(id);
        return city;
    }

    @Transactional
    public List<City> getAll() {
        List<City> cityList = new ArrayList<>();
        for (City city: cityDAO.getAll()) {
            cityList.add(city);
        }
        return cityList;
    }

    @Transactional
    public void update(City city) {
        cityDAO.update(city);
    }

    @Transactional
    public void delete(Long id) {
        cityDAO.delete(id);
    }

    public List<City> getByName(String name) {
        return cityDAO.getByName(name);
    }
}
