package com.project.model;
public class Warehouse {
    private int id;
    private String name;
    private int capacity;
    private String address;
    private String contact;
    private int currentInventory;

    public Warehouse() {
    }

    public Warehouse(String name, int capacity, String address, String contact, int currentInventory) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.contact = contact;
        this.currentInventory = currentInventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(int currentInventory) {
        this.currentInventory = currentInventory;
    }
}
