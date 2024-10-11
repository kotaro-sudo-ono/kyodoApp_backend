package com.exmple.kyudo_app.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="match")
public class match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID matchId;
    private Date date;



    public UUID getMatchId() {
        return matchId;
    }
    public void setMatchId(UUID id) {
        this.matchId = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date  date) {
        this.date = date;
    }

}
