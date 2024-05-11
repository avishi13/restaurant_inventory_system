package com.project.controller;
import com.project.dao.TransportationDAO;
import com.project.model.Transportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransportationController {

    @Autowired
    private TransportationDAO transportationDAO;

    @GetMapping("/transportations")
    public List<Transportation> getAllTransportations() {
        return transportationDAO.getAll();
    }

    @GetMapping("/transportations/{id}")
    public ResponseEntity<Transportation> getTransportationById(@PathVariable int id) {
        Transportation transportation = transportationDAO.getById(id);
        if (transportation != null) {
            return ResponseEntity.ok(transportation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/transportations")
    public ResponseEntity<String> createTransportation(@RequestBody Transportation transportation) {
        int result = transportationDAO.save(transportation);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Transportation created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create transportation");
        }
    }

    @PutMapping("/transportations/{id}")
    public ResponseEntity<String> updateTransportation(@PathVariable int id, @RequestBody Transportation transportation) {
        int result = transportationDAO.update(transportation, id);
        if (result > 0) {
            return ResponseEntity.ok("Transportation with ID " + id + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/transportations/{id}")
    public ResponseEntity<String> deleteTransportation(@PathVariable int id) {
        int result = transportationDAO.delete(id);
        if (result > 0) {
            return ResponseEntity.ok("Transportation with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
