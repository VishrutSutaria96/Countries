package com.example.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.model.RetrofitService
import com.example.countries.model.RetrofitHelper
import com.example.countries.model.data.Country
import kotlinx.coroutines.launch
import retrofit2.Response

class CountriesVM: ViewModel() {

    val countryApi = RetrofitHelper.getInstance().create(RetrofitService::class.java)

    private var _result = MutableLiveData<List<Country>>()
    val result = _result

   fun getCountries() {
        viewModelScope.launch{
            val response = countryApi.getCountries()
            if (response.isSuccessful) {
                result.value = response.body()
            }
        }
    }
}