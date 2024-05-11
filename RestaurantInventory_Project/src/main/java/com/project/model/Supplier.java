package com.project.model;

public class Supplier {
    private int id;
    private String name;
    private String contact;
    private String vehicleUsed;
    private String itemsDelivering;

    public Supplier() {
    }

    public Supplier(String name, String contact, String vehicleUsed, String itemsDelivering) {
        this.name = name;
        this.contact = contact;
        this.vehicleUsed = vehicleUsed;
        this.itemsDelivering = itemsDelivering;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVehicleUsed() {
        return vehicleUsed;
    }

    public void setVehicleUsed(String vehicleUsed) {
        this.vehicleUsed = vehicleUsed;
    }

    public String getItemsDelivering() {
        return itemsDelivering;
    }

    public void setItemsDelivering(String itemsDelivering) {
        this.itemsDelivering = itemsDelivering;
    }
}
