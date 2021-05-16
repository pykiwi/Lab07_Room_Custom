package com.example.roomcustomize;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AddressDAO {
    @Insert
    void addAddress(Address address);
    @Query("Select * from address")
    List<Address> getAllAddress();
    @Delete
    void deleteAddress(Address address);
    @Update
    void updateAddress(Address newAddress);
    @Query("SELECT * FROM address WHERE id = :addressId ")
    Address getByAddressId(Integer addressId);
}
