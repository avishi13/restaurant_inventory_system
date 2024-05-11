package com.project.dao;
import java.util.List;
import com.project.model.Transportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransportationDAOImpl implements TransportationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Transportation transportation) {
        String sql = "INSERT INTO restaurant_inventory.Transportation (supplier_id, vehicle_type, route, driver_contact, amount_per_trip) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, transportation.getSupplierId(), transportation.getVehicleType(), transportation.getRoute(), transportation.getDriverContact(), transportation.getAmountPerTrip());
    }

    @Override
    public int update(Transportation transportation, int id) {
        String sql = "UPDATE restaurant_inventory.Transportation SET supplier_id = ?, vehicle_type = ?, route = ?, driver_contact = ?, amount_per_trip = ? WHERE id = ?";
        return jdbcTemplate.update(sql, transportation.getSupplierId(), transportation.getVehicleType(), transportation.getRoute(), transportation.getDriverContact(), transportation.getAmountPerTrip(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM restaurant_inventory.Transportation WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Transportation> getAll() {
        return jdbcTemplate.query("SELECT * FROM restaurant_inventory.Transportation", new BeanPropertyRowMapper<>(Transportation.class));
    }

    @Override
    public Transportation getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM restaurant_inventory.Transportation WHERE id = ?",
                new BeanPropertyRowMapper<>(Transportation.class), id);
    }
}
