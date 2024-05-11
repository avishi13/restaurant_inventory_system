package com.project.dao;
import java.util.List;
import com.project.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Supplier supplier) {
        String sql = "INSERT INTO restaurant_inventory.Supplier (name, contact, vehicle_used, items_delivering) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                supplier.getName(),
                supplier.getContact(),
                supplier.getVehicleUsed(),
                supplier.getItemsDelivering());
    }

    @Override
    public int update(Supplier supplier, int id) {
        String sql = "UPDATE restaurant_inventory.Supplier SET name = ?, contact = ?, vehicle_used = ?, items_delivering = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                supplier.getName(),
                supplier.getContact(),
                supplier.getVehicleUsed(),
                supplier.getItemsDelivering(),
                id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM restaurant_inventory.Supplier WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Supplier> getAll() {
        return jdbcTemplate.query("SELECT * FROM restaurant_inventory.Supplier",
                new BeanPropertyRowMapper<>(Supplier.class));
    }

    @Override
    public Supplier getById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM restaurant_inventory.Supplier WHERE id = ?",
                new BeanPropertyRowMapper<>(Supplier.class),
                id);
    }
}