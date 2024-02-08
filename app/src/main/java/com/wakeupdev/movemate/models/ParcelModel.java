package com.wakeupdev.movemate.models;

import com.wakeupdev.movemate.enums.State;

public class ParcelModel {
    private String id;
    private String parcelName;
    private String trackingId;
    private String origin;
    private String destination;
    private State state;
    private String message;
    private String deliveryCost;
    private String arrivalDate;

    public ParcelModel(String id, String parcelName, String trackingId, String origin,
                       String destination, State state, String message, String deliveryCost, String arrivalDate) {
        this.id = id;
        this.parcelName = parcelName;
        this.trackingId = trackingId;
        this.origin = origin;
        this.destination = destination;
        this.state = state;
        this.message = message;
        this.deliveryCost = deliveryCost;
        this.arrivalDate = arrivalDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
