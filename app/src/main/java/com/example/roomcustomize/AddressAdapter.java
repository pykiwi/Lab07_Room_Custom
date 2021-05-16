package com.example.roomcustomize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<Address> listAddress;
    private OnClickItem updateClick;
    private OnClickItem deleteClick;
    private int layout;
    public AddressAdapter(Context context, List<Address> listAddress, int layout,
                          OnClickItem updateClick, OnClickItem deleteClick)  {
        this.context = context;
        this.listAddress = listAddress;
        this.layout = layout;
        this.updateClick = updateClick;
        this.deleteClick = deleteClick;
    }
    @Override
    public int getCount() {
        return listAddress.size();
    }

    @Override
    public long getItemId(int position) {
        return listAddress.get(position).getId();
    }
    @Override
    public Object getItem(int position) {
        return listAddress.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        TextView stt = view.findViewById(R.id.stt);
        TextView address = view.findViewById(R.id.address);
        ImageView remove = view.findViewById(R.id.iconRemove);
        ImageView edit = view.findViewById(R.id.iconEdit);
        int id = listAddress.get(position).getId();
        stt.setText(id+ ". ");
        address.setText(listAddress.get(position).getAddress());
        remove.setOnClickListener(v -> {
            this.deleteClick.onClick(id );
        });

        edit.setOnClickListener(v -> {
            this.updateClick.onClick(id);
        });
        return view;

    }
}
