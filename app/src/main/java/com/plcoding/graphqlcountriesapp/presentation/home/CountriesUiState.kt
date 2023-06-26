package com.plcoding.graphqlcountriesapp.presentation.home

import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity

data class CountriesUiState(
    val countries: List<CountryEntity> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountryEntity? = null
)
