/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Doggo
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme (darkTheme = true) {
                PuppyAdoptionApp(viewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun PuppyAdoptionApp(viewModel: MainViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                doggoList = viewModel.doggos,
                navigateToDetail = { doggo ->
                    navController.navigate("detail/${doggo.id}")
                }) }
        composable("detail/{id}") { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            val doggo = viewModel.doggos.find { it.id == id }

            doggo?.let {
                DetailScreen(
                    doggo = doggo,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PuppyAdoptionTheme {
        HomeScreen(doggosPreview){}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PuppyAdoptionTheme(darkTheme = true) {
        HomeScreen(doggosPreview){}
    }
}

val doggoPreview = Doggo(
    "Peter Pan",
    "Puppy",
    R.drawable.peter_pan_01,
    "Male",
    "Affenpinscher",
    "Mangilao, GU",
    "Vaccinations up to date"
)

val doggosPreview: List<Doggo> = listOf(
    Doggo(
        "Paisley",
        "Adult",
        R.drawable.paisley_01,
        "Female",
        "Affenpinscher",
        "Mangilao, GU",
        "Vaccinations up to date"
    ),
    Doggo(
        "Peter Pan",
        "Puppy",
        R.drawable.peter_pan_01,
        "Male",
        "Affenpinscher",
        "Mangilao, GU",
        "Vaccinations up to date"
    ),
    Doggo(
        "Mocha",
        "Puppy",
        R.drawable.mocha_01,
        "Female",
        "Pug & Affenpinscher mix",
        "Mangilao, GU",
        "Vaccinations up to date"
    ),
    Doggo(
        "Audi",
        "Young",
        R.drawable.audi_01,
        "Female",
        "Chihuahua & Jack Russel Terrier mix",
        "Mangilao, GU",
        "Vaccinations up to date"
    ),
)