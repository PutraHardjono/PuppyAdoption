package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Doggo

@Composable
fun DetailScreen(
    doggo: Doggo,
    navigateUp: () -> Unit
) {
    val modifierPaddingStart = Modifier.padding(start = 16.dp)

    val scrollState = rememberScrollState()

    Scaffold {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            HeaderAndNavigation(doggo, navigateUp)
            NameInfo(doggo)
            LocationInfo(doggo, modifierPaddingStart)
            BreedInfo(doggo, modifierPaddingStart)
            AgeInfo(doggo, modifierPaddingStart)
            DescriptionText(modifierPaddingStart)
            DescriptionInfo(doggo, modifierPaddingStart)
            AdoptButton()
        }
    }
}

@Composable
private fun AdoptButton() {
    Spacer(modifier = Modifier.height(32.dp))
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "ADOPT", style = MaterialTheme.typography.button)
    }
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
private fun DescriptionInfo(
    doggo: Doggo,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = doggo.description, modifier = modifier)
}

@Composable
private fun DescriptionText(modifier: Modifier) {
    Spacer(modifier = Modifier.height(16.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = "Description",
            style = MaterialTheme.typography.h6,
            modifier = modifier
        )
    }
}

@Composable
private fun AgeInfo(doggo: Doggo, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = modifier) {
        Icon(painter = painterResource(id = R.drawable.ic_age), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = doggo.age)
    }
}

@Composable
private fun BreedInfo(doggo: Doggo, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(32.dp))
    Row(modifier = modifier) {
        Icon(painter = painterResource(id = R.drawable.ic_dog_paw), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = doggo.breed)
    }
}

@Composable
private fun HeaderAndNavigation(
    doggo: Doggo,
    navigateUp: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(id = doggo.image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(24.dp, 24.dp),
            )
        }
    }
}

@Composable
private fun NameInfo(doggo: Doggo) {
    Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        Text(
            text = doggo.name,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(
                id = if (doggo.gender.equals(
                        "male",
                        true
                    )
                ) R.drawable.ic_male else R.drawable.ic_female
            ),
            contentDescription = null,
            modifier = Modifier.size(40.dp, 40.dp)
        )
    }
}

@Composable
private fun LocationInfo(doggo: Doggo, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null, Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = doggo.location, style = MaterialTheme.typography.caption)
        }
    }
}