package by.dao.impl;

import by.dao.InfoDAO;
import by.dao.repo.InfoRepository;
import by.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InfoDAOImpl implements InfoDAO {
    @Autowired
    InfoRepository infoRepository;

    public void create(Info info) {
        infoRepository.save(info);
    }

    public Info get(Long id) {
        return infoRepository.findOne(id);
    }

    public List<Info> getAll() {
        List<Info> infoList = new ArrayList<>();
        for (Info info: infoRepository.findAll()) {
            infoList.add(info);
        }
        return infoList;
    }

    public void update(Info info) {
        infoRepository.save(info);
    }

    public void delete(Long id) {
        infoRepository.delete(id);
    }
}
