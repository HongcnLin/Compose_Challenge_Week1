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
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pokemon

/**
 * Summary:
 *
 * @author dongml1
 * @date 2021/3/2 18:27
 */
class DetailsActivity : AppCompatActivity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val mPokemon: Pokemon = intent.getSerializableExtra("pokemon") as Pokemon
        setContent {
            PokeMonDetails(pokemon = mPokemon) {
                Toast.makeText(this, "capture ${it.cnName}!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun PokeMonDetails(pokemon: Pokemon, onCapture: (Pokemon) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = pokemon.bgColorId))
    ) {
        Image(
            painterResource(pokemon.pictureResId),
            "Dog picture: ${pokemon.cnName}",
            Modifier
                .aspectRatio(1f)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(Modifier.padding(16.dp, 1.dp)) {
                Text(
                    pokemon.name,
                    Modifier
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.h3
                )
                ProvideTextStyle(MaterialTheme.typography.h5) {
                    Text(text = "别名:${pokemon.cnName}", Modifier.padding(6.dp))
                    Text("身高: ${pokemon.stature}", Modifier.padding(4.dp))
                    Text("体重: ${pokemon.weight}", Modifier.padding(4.dp))
                    Text("种类: ${pokemon.species}", Modifier.padding(4.dp))
                    Text("属性: ${pokemon.attribute}", Modifier.padding(4.dp))
                }
            }
            Image(
                painterResource(id = R.drawable.icon_jinglq),
                "Capture!",
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .clickable { onCapture(pokemon) }
            )
        }
    }
}
