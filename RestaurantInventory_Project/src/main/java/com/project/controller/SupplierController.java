package com.project.controller;

import com.project.dao.SupplierDAO;
import com.project.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierDAO supplierDAO;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAll();
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        Supplier supplier = supplierDAO.getById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/suppliers")
    public ResponseEntity<String> createSupplier(@RequestBody Supplier supplier) {
        int result = supplierDAO.save(supplier);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Supplier created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create supplier");
        }
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<String> updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        int result = supplierDAO.update(supplier, id);
        if (result > 0) {
            return ResponseEntity.ok("Supplier with ID " + id + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable int id) {
        int result = supplierDAO.delete(id);
        if (result > 0) {
            return ResponseEntity.ok("Supplier with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
