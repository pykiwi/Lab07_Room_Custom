package com.example.roomcustomize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ConnectDatabase connectDb;
    private AddressDAO addressDAO;
    private ListView listView;
    private Button btnSave, btnCancel;
    private OnClickItem deleteClick, updateClick;
    private EditText editTextAddress;
    private Address selectedAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectDb = ConnectDatabase.getInstance(getApplicationContext());
        addressDAO = connectDb.addressDAO();

        listView = findViewById(R.id.listview);
        editTextAddress = findViewById(R.id.address);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        updateClick = id -> {
            selectedAddress = addressDAO.getByAddressId(id);
            String name = selectedAddress.getAddress();
            editTextAddress.setText(name);
        };
        deleteClick = id -> {
            addressDAO.deleteAddress(addressDAO.getByAddressId(id));
            updateData();
        };

        listView.setAdapter(new AddressAdapter(MainActivity.this,
                addressDAO.getAllAddress(),
                R.layout.item_view,
                updateClick,
                deleteClick));
        btnSave.setOnClickListener(v ->{
            String address = editTextAddress.getText().toString();
            if (selectedAddress != null){
                selectedAddress.setAddress(address);
                addressDAO.updateAddress(selectedAddress);
                selectedAddress = null;
                editTextAddress.setText("");
            }
            else{
                Address obj_address = new Address(address);
                addressDAO.addAddress(obj_address);
            }
            updateData();
        });
        btnCancel.setOnClickListener(v-> {

            editTextAddress.setText("");
            selectedAddress = null;
        });
    }
    private  void updateData(){

        listView.setAdapter(new AddressAdapter(MainActivity.this,
                addressDAO.getAllAddress(),
                R.layout.item_view,
                updateClick,
                deleteClick));
    }
}