package com.plcoding.graphqlcountriesapp.domain.usecase

import com.plcoding.graphqlcountriesapp.domain.client.CountryClient
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity

class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(code: String): DetailedCountryEntity? {
        return countryClient.getCountry(code)
    }
}