package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Doggo

class MainViewModel : ViewModel() {

    var doggos: List<Doggo> by mutableStateOf(
        listOf(
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
    )
    private set


}