package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Doggo
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionTheme

@Composable
fun HomeScreen(
    doggoList: List<Doggo>,
    navigateToDetail: (Doggo) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.title)) }
            )
        }
    ) {
        LazyColumn {
            items(doggoList) { doggo ->
                ItemCard(
                    doggo = doggo,
                    modifier = Modifier.clickable { navigateToDetail(doggo) }
                )
            }
        }
    }
}

@Composable
fun ItemCard(
    doggo: Doggo,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 2.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.clip(RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp))) {
                Image(
                    painter = painterResource(id = doggo.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .aspectRatio(1f)
                        .clip(shape = MaterialTheme.shapes.small)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Row {
                    Text(
                        text = doggo.name,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
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
                        modifier = Modifier
                            .width(40.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = doggo.breed, style = MaterialTheme.typography.body2)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = doggo.location, style = MaterialTheme.typography.caption)
                }
            }
        }
    }


}

@Preview
@Composable
fun ItemCardPreview() {
    PuppyAdoptionTheme {
        Surface(color = MaterialTheme.colors.surface) {
            ItemCard(doggoPreview)
        }
    }
}