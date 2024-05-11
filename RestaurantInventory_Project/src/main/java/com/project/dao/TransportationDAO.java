package com.project.dao;


import java.util.List;
import com.project.model.Transportation;

public interface TransportationDAO {
    int save(Transportation transportation);
    int update(Transportation transportation, int id);
    int delete(int id);
    List<Transportation> getAll();
    Transportation getById(int id);
}
