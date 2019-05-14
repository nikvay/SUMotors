package com.nikvay.sumotors.network;


import com.nikvay.sumotors.ui.module.SuccessModule;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST(EndApi.REPORT_LIST)
    @FormUrlEncoded
    Call<SuccessModule> reportListCall(@Field("from_date") String from_date,
                                       @Field("to_date") String to_date);


//    @Headers("Content-Type: application/json")
    @GET(EndApi.DESIGNATION_LIST)
    Call<SuccessModule> designationListCall();

    @POST(EndApi.EMP_LIST)
    @FormUrlEncoded
    Call<SuccessModule> empListCall(@Field("designation_id") String designation_id);

}
