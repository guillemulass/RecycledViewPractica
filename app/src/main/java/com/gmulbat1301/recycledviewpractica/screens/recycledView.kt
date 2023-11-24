package com.gmulbat1301.recycledviewpractica.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Ejemplo1() {
    val myList = listOf("Marta", "Pepe", "Manolo", "Jaime")
    LazyColumn {
        item { Text(text = "Cabecera") }
        items(myList.size) {
            Text(text = "Este es el item $it: ${myList[it]}")
        }
        item { Text(text = "Pie de página") }
    }
}

