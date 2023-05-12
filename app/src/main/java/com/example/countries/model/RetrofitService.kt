package com.example.countries.model

import com.example.countries.model.data.Country
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/DevTides/countries/master/countriesV2.json")
    suspend fun getCountries(): Response<List<Country>>
}