package com.example.roomcustomize;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "address")
public class Address implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String address;


    public Address(int id, String address) {
        this.id = id;
        this.address = address;
    }
    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
