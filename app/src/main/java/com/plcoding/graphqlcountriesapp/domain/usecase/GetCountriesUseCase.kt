package com.plcoding.graphqlcountriesapp.domain.usecase

import com.plcoding.graphqlcountriesapp.domain.client.CountryClient
import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<CountryEntity> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}