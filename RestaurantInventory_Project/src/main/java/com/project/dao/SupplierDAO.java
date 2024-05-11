package com.project.dao;

import java.util.List;
import com.project.model.Supplier;

public interface SupplierDAO {
    int save(Supplier supplier);
    int update(Supplier supplier, int id);
    int delete(int id);
    List<Supplier> getAll();
    Supplier getById(int id);
}
