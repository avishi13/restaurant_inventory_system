package com.project.dao;

import java.util.List;
import com.project.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseDAOImpl implements WarehouseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Warehouse warehouse) {
        String sql = "INSERT INTO restaurant_inventory.Warehouse (name, capacity, address, contact, current_inventory) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, warehouse.getName(), warehouse.getCapacity(), warehouse.getAddress(), warehouse.getContact(), warehouse.getCurrentInventory());
    }

    @Override
    public int update(Warehouse warehouse, int id) {
        String sql = "UPDATE restaurant_inventory.Warehouse SET name = ?, capacity = ?, address = ?, contact = ?, current_inventory = ? WHERE id = ?";
        return jdbcTemplate.update(sql, warehouse.getName(), warehouse.getCapacity(), warehouse.getAddress(), warehouse.getContact(), warehouse.getCurrentInventory(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM restaurant_inventory.Warehouse WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Warehouse> getAll() {
        return jdbcTemplate.query("SELECT * FROM restaurant_inventory.Warehouse", new BeanPropertyRowMapper<>(Warehouse.class));
    }

    @Override
    public Warehouse getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM restaurant_inventory.Warehouse WHERE id = ?",
                new BeanPropertyRowMapper<>(Warehouse.class), id);
    }
}
