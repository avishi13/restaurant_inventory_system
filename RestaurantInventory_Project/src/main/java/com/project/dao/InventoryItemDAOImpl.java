package com.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.project.model.InventoryItem;
import java.util.List;

@Repository
public class InventoryItemDAOImpl implements InventoryItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(InventoryItem inventoryItem) {
        String sql = "INSERT INTO restaurant_inventory.InventoryItem (food_name, quantity, expiry_date, item_cost) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            inventoryItem.getFoodName(), 
            inventoryItem.getQuantity(), 
            inventoryItem.getExpiryDate(), 
            inventoryItem.getItemCost());
    }

    @Override
    public int update(InventoryItem inventoryItem, int id) {
        String sql = "UPDATE restaurant_inventory.InventoryItem SET food_name = ?, quantity = ?, expiry_date = ?, item_cost = ? WHERE id = ?";
        return jdbcTemplate.update(sql, 
            inventoryItem.getFoodName(), 
            inventoryItem.getQuantity(), 
            inventoryItem.getExpiryDate(), 
            inventoryItem.getItemCost(), 
            id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM restaurant_inventory.InventoryItem WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<InventoryItem> getAll() {
        return jdbcTemplate.query("SELECT * FROM restaurant_inventory.InventoryItem",
                new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    @Override
    public InventoryItem getById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM restaurant_inventory.InventoryItem WHERE id = ?",
                new BeanPropertyRowMapper<>(InventoryItem.class),
                id);
    }
}
