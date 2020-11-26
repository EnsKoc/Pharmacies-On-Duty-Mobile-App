package com.dutypharmacy.eczacim;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PharmacyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Gson gson = new GsonBuilder().setLenient().create();
    TextView textView ;
    Typeface tf1;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Cons.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        textView = (TextView)findViewById(R.id.nöbetciEczaneler);
        tf1= Typeface.createFromAsset(getAssets(),"font/caviarDreams.ttf");
        textView.setTypeface(tf1);

        recyclerView = (RecyclerView)findViewById(R.id.Listview);
        GetPharmacy();
    }

    public void initPosts(ArrayList<PharmacyModel> pharmacyModels){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        PharmacyAdapter pharmacyAdapter = new PharmacyAdapter(pharmacyModels, getApplicationContext());
        recyclerView.setAdapter(pharmacyAdapter);

    }

    public void GetPharmacy(){
        PharmacyApi pharmacyApi =retrofit.create(PharmacyApi.class);

        Call<List<PharmacyModel>> call = pharmacyApi.GetPharmacy();

        call.enqueue(new Callback<List<PharmacyModel>>() {
            @Override
            public void onResponse(Call<List<PharmacyModel>> call, Response<List<PharmacyModel>> response) {

                ArrayList<PharmacyModel> listem = new ArrayList<>();
                listem = (ArrayList<PharmacyModel>)response.body();
                initPosts(listem);


            }

            @Override
            public void onFailure(Call<List<PharmacyModel>> call, Throwable t) {

            }
        });
    }
}
