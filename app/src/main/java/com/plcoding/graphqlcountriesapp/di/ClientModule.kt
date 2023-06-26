package com.plcoding.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.plcoding.graphqlcountriesapp.data.client.CountryClientImpl
import com.plcoding.graphqlcountriesapp.domain.client.CountryClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return CountryClientImpl(apolloClient)
    }
}