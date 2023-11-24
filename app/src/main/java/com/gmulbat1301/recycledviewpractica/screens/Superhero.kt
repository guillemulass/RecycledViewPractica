package com.gmulbat1301.recycledviewpractica.screens

import android.widget.Toast
import com.gmulbat1301.recycledviewpractica.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Superhero(val superheroName: String, val realName: String, val publisher: String, @DrawableRes var photo: Int)

fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ) {
        items(getSuperheroes()) {
            ItemHero(superhero = it,
                onItemSelected = { Toast.makeText(context,it.realName,Toast.LENGTH_SHORT)})
        }
    }

}

@Composable
fun ItemHero(superhero: Superhero,onItemSelected: (Superhero) ->
Unit) {

    Card (
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){

            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = superhero.superheroName, fontSize = 20.sp)
            Text(text = superhero.realName, fontSize = 15.sp)
            Row(
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = superhero.publisher,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(bottom = 5.dp))
            }
           
        }
    }

}



