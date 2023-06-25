package com.plcoding.graphqlcountriesapp.data.client

import com.apollographql.apollo3.ApolloClient
import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.client.CountryClient
import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity
import com.plcoding.graphqlcountriesapp.domain.mapper.toCountryEntity
import com.plcoding.graphqlcountriesapp.domain.mapper.toDetailedCountyEntity

class CountryClientImpl(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<CountryEntity> {
        return apolloClient.query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {
                it.toCountryEntity()
            }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountryEntity? {
        return apolloClient.query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountyEntity()
    }
}