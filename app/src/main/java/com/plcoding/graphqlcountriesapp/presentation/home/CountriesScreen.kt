package com.plcoding.graphqlcountriesapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.plcoding.graphqlcountriesapp.domain.entity.CountryEntity
import com.plcoding.graphqlcountriesapp.domain.entity.DetailedCountryEntity

@Composable
fun CountriesScreen(
    state: CountriesUiState,
    onSelectCountry: (code: String) -> Unit,
    onDismissCountryDialog: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.countries) { country ->
                    CountryItem(
                        country = country,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectCountry(country.code ?: "unknown") }
                            .padding(16.dp)
                    )
                }
            }
        }

        if (state.selectedCountry != null) {
            CountryDialog(
                countryDetail = state.selectedCountry,
                onDismiss = onDismissCountryDialog,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun CountryItem(
    country: CountryEntity,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.emoji ?: "unknown",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = country.name ?: "unknown", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = country.capital ?: "unknown", fontSize = 16.sp)
        }
    }
}

@Composable
private fun CountryDialog(
    countryDetail: DetailedCountryEntity,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {

    val joinedLanguages = remember(countryDetail.languages) {
        countryDetail.languages?.joinToString()
    }

    Dialog(onDismissRequest = onDismiss) {
        Column(modifier = modifier) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = countryDetail.emoji ?: "unknown",
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = countryDetail.name ?: "unknown",
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Continent: " + countryDetail.continent)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Currency: " + countryDetail.currency)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Capital: " + countryDetail.capital)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Language(s): $joinedLanguages")
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}