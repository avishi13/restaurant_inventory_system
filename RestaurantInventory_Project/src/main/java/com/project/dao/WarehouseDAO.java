package com.project.dao;
import java.util.List;
import com.project.model.Warehouse;

public interface WarehouseDAO {
    int save(Warehouse warehouse);
    int update(Warehouse warehouse, int id);
    int delete(int id);
    List<Warehouse> getAll();
    Warehouse getById(int id);
}
