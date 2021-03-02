package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composetest.Pokemon

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
            PokeMonDetails(pokemon = mPokemon)
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
        Box {
            Image(
                painterResource(pokemon.pictureResId),
                "Dog picture: ${pokemon.cnName}",
                Modifier
                    .aspectRatio(1f)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { onCapture(pokemon) },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                painterResource(id = R.drawable.icon_jinglq)
            }
        }
        Column(Modifier.padding(16.dp, 1.dp)) {
            Text(
                "${pokemon.name}",
                Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.h3
            )
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text(text = "别名:${pokemon.cnName}")
                Text("身高: ${pokemon.stature}")
                Text("体重: ${pokemon.weight}")
                Text("种类: ${pokemon.species}")
                Text("属性: ${pokemon.attribute}")
            }
        }
    }
}