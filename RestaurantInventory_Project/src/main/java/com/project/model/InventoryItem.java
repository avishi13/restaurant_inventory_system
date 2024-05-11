package com.project.model;


import java.util.Date;

public class InventoryItem {

   
    private int id;

   
    private String food_name;

  
    private int quantity;

    
    private Date expiry_date;

   
    private float item_cost;


   

    public InventoryItem() {
    }

    public InventoryItem(String food_name, int quantity, Date expiry_date, float item_cost) {
        this.food_name = food_name;
        this.quantity = quantity;
        this.expiry_date=  expiry_date;
        this.item_cost = item_cost;
      
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return food_name;
    }

    public void setFoodName(String foodName) {
        this.food_name = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiry_date;
    }

    public void setExpiryDate(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public float getItemCost() {
        return item_cost;
    }

    public void setItemCost(float item_cost) {
        this.item_cost = item_cost;
    }

  
}
