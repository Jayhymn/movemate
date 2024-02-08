package com.wakeupdev.movemate.models;

public class VehicleModel {
    private String id;
    private String vehicleType;
    private String transitType;
    private int imageUrl;

    public VehicleModel(String id, String vehicleType, String transitType, int imageUrl) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.transitType = transitType;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getTransitType() {
        return transitType;
    }

    public void setTransitType(String transitType) {
        this.transitType = transitType;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
