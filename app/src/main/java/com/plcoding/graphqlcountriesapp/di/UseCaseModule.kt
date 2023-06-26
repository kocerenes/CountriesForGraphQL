package com.plcoding.graphqlcountriesapp.di

import com.plcoding.graphqlcountriesapp.domain.client.CountryClient
import com.plcoding.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }
}