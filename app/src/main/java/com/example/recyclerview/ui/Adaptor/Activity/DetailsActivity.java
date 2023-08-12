package com.example.recyclerview.ui.Adaptor.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.databinding.ActivityDetailsBinding;
import com.example.recyclerview.ui.Adaptor.Utilitis.Const;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private String countryImageUrl, countryName, countryLanguage, countryPopulation, countryCurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        countryImageUrl= getIntent().getStringExtra(Const.COUNTRY_IMAGE_KEY);
//        countryName= getIntent().getStringExtra(Const.COUNTRY_NAME_KEY);
//        countryLanguage= getIntent().getStringExtra(Const.COUNTRY_LANGUAGE_KEY);
//        countryPopulation= getIntent().getStringExtra(Const.COUNTRY_POPULATION_KEY);
//        countryCurrency= getIntent().getStringExtra(Const.COUNTRY_CURRENCY_KEY);

        Bundle bundle=getIntent().getExtras();
        Glide.with(this)
                .load(countryImageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.countryFlag);

        countryImageUrl= bundle.getString(Const.COUNTRY_IMAGE_KEY);
        countryName= bundle.getString(Const.COUNTRY_NAME_KEY);
        countryLanguage= bundle.getString(Const.COUNTRY_LANGUAGE_KEY);
        countryPopulation= bundle.getString(Const.COUNTRY_POPULATION_KEY);
        countryCurrency=bundle.getString(Const.COUNTRY_CURRENCY_KEY);
        Glide.with(this)
                .load(countryImageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.countryFlag);


        binding.textviewCountryName.setText("Country name: "+ countryName);
        binding.textviewCountryPupulation.setText("Country Language: "+countryPopulation);
        binding.textviewCountryLanguage.setText("CountryPopulation: "+countryLanguage);
        binding.textviewCountryCurrency.setText("CountryCurrency: "+countryCurrency);


    }
}