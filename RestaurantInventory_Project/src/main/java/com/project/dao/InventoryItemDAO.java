package com.project.dao;
//InventoryItemDAO.java

import com.project.model.InventoryItem;
import java.util.List;

public interface InventoryItemDAO {
 int save(InventoryItem inventoryItem);
 int update(InventoryItem inventoryItem, int id);
 int delete(int id);
 List<InventoryItem> getAll();
 InventoryItem getById(int id);
}
