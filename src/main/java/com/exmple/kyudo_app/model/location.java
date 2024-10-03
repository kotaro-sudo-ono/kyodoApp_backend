package com.exmple.kyudo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;

@Entity
public class location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String locationName;
    private String locationPoint;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long id) {
        this.locationId = id;
    }

    public String  getLocationName() {
        return locationName;
    }
    public void setlocationName(String  name) {
        this.locationName = name;
    }
    public String  getLocationPoint() {
        return locationPoint;
    }
    public void setLocationPoint(String id) {
        this.locationPoint = id;
    }
}
