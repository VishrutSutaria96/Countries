package com.example.countries.view

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.viewmodel.CountriesVM


class MainActivity : AppCompatActivity() {

    private val viewModel: CountriesVM by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val countriesAdapter = CountryRecyclerViewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*val dividerItemDecoration = DividerItemDecoration(
            cont,
            LinearLayoutManager(Context).getOrientation()
        )*/

        binding.countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
        viewModel.result.observe(this) {
            countriesAdapter.updateCountries(it)
        }

        viewModel.getCountries()
    }
}