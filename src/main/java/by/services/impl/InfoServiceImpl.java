package by.services.impl;

import by.dao.InfoDAO;
import by.entity.Info;
import by.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoDAO infoDAO;

    @Transactional
    public void create(Info info) {
        infoDAO.create(info);
    }

    @Transactional
    public Info get(Long id) {
        Info info;
        info = infoDAO.get(id);
        return info;
    }

    @Transactional
    public List<Info> getAll() {
        List<Info> infoList = new ArrayList<>();
        for (Info info: infoDAO.getAll()) {
            infoList.add(info);
        }
        return infoList;
    }

    @Transactional
    public void update(Info info) {
        infoDAO.update(info);
    }

    @Transactional
    public void delete(Long id) {
        infoDAO.delete(id);
    }
}