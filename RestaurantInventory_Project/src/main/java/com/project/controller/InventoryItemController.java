package com.project.controller;

import com.project.dao.InventoryItemDAO;
import com.project.model.InventoryItem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/inventory-items")
public class InventoryItemController {

    @Autowired
    private InventoryItemDAO inventoryItemDAO;

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        List<InventoryItem> inventoryItems = inventoryItemDAO.getAll();
        if (inventoryItems != null && !inventoryItems.isEmpty()) {
            return ResponseEntity.ok(inventoryItems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getInventoryItemById(@PathVariable int id) {
        InventoryItem inventoryItem = inventoryItemDAO.getById(id);
        if (inventoryItem != null) {
            return ResponseEntity.ok(inventoryItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        int result = inventoryItemDAO.save(inventoryItem);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Inventory item created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create inventory item");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInventoryItem(@PathVariable int id, @RequestBody InventoryItem inventoryItem) {
        int result = inventoryItemDAO.update(inventoryItem, id);
        if (result > 0) {
            return ResponseEntity.ok("Inventory item with ID " + id + " updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventoryItem(@PathVariable int id) {
        int result = inventoryItemDAO.delete(id);
        if (result > 0) {
            return ResponseEntity.ok("Inventory item with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
