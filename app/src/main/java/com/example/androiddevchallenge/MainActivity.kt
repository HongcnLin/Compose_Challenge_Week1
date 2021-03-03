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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.data.Pokemon
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(context: Context?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokemon Home")
                }
            )
        },
    ) {
        PokemonList(FakeData.pokemons) { pokemon ->
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("pokemon", pokemon)
            context!!.startActivity(intent)
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Pokemon>, onItemClick: (Pokemon) -> Unit = {}) {
    LazyColumn(
        Modifier
            .background(Color.DarkGray)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//        for ((index, pk) in FakeData.pokemons.withIndex()) {
//            if ((index % 2) == 0) {
//                PokemonListItem1(pk,
//                    Modifier
//                        .clickable { onItemClick(pk) }
//                        .fillMaxWidth()
//                )
//            } else {
//                PokemonListItem2(pk,
//                    Modifier
//                        .clickable { onItemClick(pk) }
//                        .fillMaxWidth()
//                )
//            }
//        }
        for ((index, pk) in pokemons.withIndex()) {
            item {
                if ((index % 2) == 0) {
                    PokemonListItem1(
                        pk,
                        Modifier
                            .clickable { onItemClick(pk) }
                            .fillMaxWidth()
                    )
                } else {
                    PokemonListItem2(
                        pk,
                        Modifier
                            .clickable { onItemClick(pk) }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonListItem1(pokemon: Pokemon, modifier: Modifier) {
    Card(modifier, elevation = 4.dp, backgroundColor = pokemon.bgColor) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(pokemon.pictureResId),
                "Picture of dog: ${pokemon.name}",
                Modifier
                    .size(180.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    pokemon.name,
                    Modifier.padding(vertical = 5.dp), style = MaterialTheme.typography.h4
                )
                Text(pokemon.species, style = MaterialTheme.typography.h6)
                Text(pokemon.attribute, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Composable
fun PokemonListItem2(pokemon: Pokemon, modifier: Modifier) {
    Card(modifier, elevation = 4.dp, backgroundColor = pokemon.bgColor) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    pokemon.name,
                    Modifier.padding(vertical = 5.dp), style = MaterialTheme.typography.h4
                )
                Text(pokemon.species, style = MaterialTheme.typography.h6)
                Text(pokemon.attribute, style = MaterialTheme.typography.h6)
            }
            Image(
                painterResource(pokemon.pictureResId),
                "Picture of dog: ${pokemon.name}",
                Modifier
                    .size(180.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(null)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        // MyApp()
    }
}
