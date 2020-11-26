package com.dutypharmacy.eczacim;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolder> {

    ArrayList<PharmacyModel> pharmacyModels;
    Context context;


    public PharmacyAdapter(ArrayList<PharmacyModel> pharmacyModels, Context context){
        this.pharmacyModels=pharmacyModels;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacy_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textViewName.setText(pharmacyModels.get(position).getEczaneAdi()+" ECZANESİ");
        holder.TextViewCounty.setText("İLÇE: "+pharmacyModels.get(position).getEczaneIlceAdi());
        holder.TextViewAddress.setText("ADRES: "+pharmacyModels.get(position).getEczaneAdres());
    }

    @Override
    public int getItemCount() {
        return pharmacyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView TextViewCounty;
        TextView TextViewAddress;
        Typeface tf1;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.TextViewName);
            TextViewCounty = itemView.findViewById(R.id.TextViewCounty);
            TextViewAddress = itemView.findViewById(R.id.TextViewAddress);
        }
    }
}
