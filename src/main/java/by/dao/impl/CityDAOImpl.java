package by.dao.impl;

import by.dao.CityDAO;
import by.dao.repo.CityRepository;
import by.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {
    @Autowired
    CityRepository cityRepository;

    public void create(City city) {
        cityRepository.save(city);
    }

    public City get(Long id) {
        return cityRepository.findOne(id);
    }

    public List<City> getAll() {
        List<City> cityList = new ArrayList<>();
        for (City city: cityRepository.findAll()) {
            cityList.add(city);
        }
        return cityList;
    }

    public void update(City city) {
        cityRepository.save(city);
    }

    public void delete(Long id) {
        cityRepository.delete(id);
    }

    public List<City> getByName(String name) {
        return cityRepository.findByName(name);
    }
}
