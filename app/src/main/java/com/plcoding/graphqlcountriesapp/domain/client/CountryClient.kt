package com.plcoding.graphqlcountriesapp.domain.client

import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity

interface CountryClient {
    suspend fun getCountries(): List<CountryEntity>
    suspend fun getCountry(code: String): DetailedCountryEntity?
}