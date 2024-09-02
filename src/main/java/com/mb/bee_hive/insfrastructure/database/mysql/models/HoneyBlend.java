package com.mb.bee_hive.insfrastructure.database.mysql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * Class to represent the Database Object HoneyBlend right out of the MySQL DB.
 * Only used in the Database Context, later mapped to Domain Object
 */
@Entity
public class HoneyBlend {

////////////////// Fields ////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String description;
    private int quantity;


///////////////////// Getters / Setters ///////////////////////////////////////

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
