package com.example.recyclerview.model;

public class CountryModel {
    private String imageURL;
    private String countryName;
    private String countryLanguage;
    private String countryPopulation;
    private String countryCurrency;

    public CountryModel(String imageURL, String countryName, String countryLanguage, String countryPopulation, String countryCurrency) {
        this.imageURL = imageURL;
        this.countryName = countryName;
        this.countryLanguage = countryLanguage;
        this.countryPopulation = countryPopulation;
        this.countryCurrency = countryCurrency;
    }

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(String countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public String getImageURL() {
        return imageURL;
    }

    public CountryModel(String imageURL, String countryName, String english, String s) {
        this.imageURL = imageURL;
        this.countryName = countryName;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
