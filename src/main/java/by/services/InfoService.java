package by.services;

import by.entity.City;
import by.entity.Info;

import java.util.List;

public interface InfoService {
    List<Info> getAll();
    Info get(Long id);
    void create(Info info);
    void update(Info info);
    void delete(Long id);
}
