package com.ugerodarr.iobuilders.domain.model.activityType;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ACTIVITYTYPES")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDACTIVITYTYPE")
    private BigInteger idActivityType;

    @Column(name="NAME", nullable = false)
    private String name;

    public ActivityType() {
    }

    public ActivityType(String name) {
        this.name = name;
    }

    public BigInteger getIdActivityType() {
        return idActivityType;
    }

    public void setIdActivityType(BigInteger idActivityType) {
        this.idActivityType = idActivityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
