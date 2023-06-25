package com.plcoding.graphqlcountriesapp.domain.entity

data class DetailedCountryEntity(
    val code: String?,
    val name: String?,
    val emoji: String?,
    val capital: String?,
    val currency: String?,
    val languages: List<String>?,
    val continent: String?
)
