package com.example.roomcustomize;

import android.content.Context;
import android.widget.Adapter;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Adapter.class},version = 1)
public abstract class ConnectDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "Address.db";
    private static ConnectDatabase connectDatabase;
    public  static synchronized ConnectDatabase getInstance(Context context){
        if(connectDatabase == null){
            connectDatabase = Room.databaseBuilder(context.getApplicationContext(),ConnectDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return connectDatabase;
    }
    public abstract AddressDAO addressDAO();
}
