package com.dutypharmacy.eczacim;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PharmacyApi {
    @GET("Account/NobetciEczaneList?ilKodu=25&ilceKodu=Tumu&nobetGunu=0")
    Call<List<PharmacyModel>> GetPharmacy();
}
