package com.example.countries.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.CountryItemBinding
import com.example.countries.model.data.Country

class CountryRecyclerViewAdapter(var countries: List<Country>): RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }


    class CountryViewHolder(private val binding: CountryItemBinding, view: View? = null) : RecyclerView.ViewHolder(
        binding.root){
        private val countryNameTV = binding.countryName
        private val countryCodeTV = binding.countryCode
        private val countryCapitalTV = binding.countryCapital
        private val countryRegionTV = binding.countryRegion
        fun bind(country: Country){
            countryNameTV.text = "Name: "+country.name
            countryCodeTV.text = "Code: "+country.code
            countryCapitalTV.text = "Capital: "+country.capital
            countryRegionTV.text = "Region: "+country.region
        }
    }

    fun updateCountries(newCountries: List<Country>) {
        countries = listOf()
        countries = newCountries
        notifyDataSetChanged()
    }
}