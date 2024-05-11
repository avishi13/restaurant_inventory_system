package com.project.model;
public class Transportation {
    private int id;
    private int supplierId;
    private String vehicleType;
    private String route;
    private String driverContact;
    private double amountPerTrip;

    public Transportation() {
    }

    public Transportation(int supplierId, String vehicleType, String route, String driverContact, double amountPerTrip) {
        this.supplierId = supplierId;
        this.vehicleType = vehicleType;
        this.route = route;
        this.driverContact = driverContact;
        this.amountPerTrip = amountPerTrip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    public double getAmountPerTrip() {
        return amountPerTrip;
    }

    public void setAmountPerTrip(double amountPerTrip) {
        this.amountPerTrip = amountPerTrip;
    }
}
