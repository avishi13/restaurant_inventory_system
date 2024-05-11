package com.project.controller;

import com.project.dao.WarehouseDAO;
import com.project.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseController {

    @Autowired
    private WarehouseDAO warehouseDAO;

    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouses() {
        return warehouseDAO.getAll();
    }

    @GetMapping("/warehouses/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int id) {
        Warehouse warehouse = warehouseDAO.getById(id);
        if (warehouse != null) {
            return ResponseEntity.ok(warehouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/warehouses")
    public ResponseEntity<String> createWarehouse(@RequestBody Warehouse warehouse) {
        int result = warehouseDAO.save(warehouse);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Warehouse created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create warehouse");
        }
    }

    @PutMapping("/warehouses/{id}")
    public ResponseEntity<String> updateWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
        int result = warehouseDAO.update(warehouse, id);
        if (result > 0) {
            return ResponseEntity.ok("Warehouse with ID " + id + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/warehouses/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable int id) {
        int result = warehouseDAO.delete(id);
        if (result > 0) {
            return ResponseEntity.ok("Warehouse with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}