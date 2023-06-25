package com.plcoding.graphqlcountriesapp.domain.mapper

import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity

fun CountryQuery.Country.toDetailedCountyEntity() = DetailedCountryEntity(
    code = this.code,
    name = this.name,
    emoji = this.emoji,
    capital = this.capital,
    currency = this.currency,
    languages = this.languages.mapNotNull { it.name },
    continent = this.continent.name
)

fun CountriesQuery.Country.toCountryEntity() = CountryEntity(
    code = this.code,
    name= this.name,
    emoji = this.emoji,
    capital = this.capital
)
