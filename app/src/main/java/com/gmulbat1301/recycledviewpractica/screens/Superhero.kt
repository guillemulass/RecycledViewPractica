package com.gmulbat1301.recycledviewpractica.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import com.gmulbat1301.recycledviewpractica.R

data class Superhero(val superheroName: String, val realName: String, val publisher: String, @DrawableRes var photo: Int){

    fun getSuperheroes(){

        val superheroList = mutableListOf("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman)

    }

}

@Composable
fun SuperHeroView() {
    LazyRow() {
        items(getSuperheroes()) {
            ItemHero(superhero = it)
        }
    }
}


