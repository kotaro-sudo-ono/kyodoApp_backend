package com.exmple.kyudo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

@Entity
public class location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Token.ID locationId;
    private String locationName;
    private String locationPoint;

    public Token.ID getLocationId() {
        return locationId;
    }

    public void setLocationId(Token.ID id) {
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
