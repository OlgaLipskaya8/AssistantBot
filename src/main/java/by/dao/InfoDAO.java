package by.dao;

import by.entity.Info;

import java.util.List;

public interface InfoDAO {
    List<Info> getAll();
    Info get(Long id);
    void create(Info info);
    void update(Info info);
    void delete(Long id);
}
