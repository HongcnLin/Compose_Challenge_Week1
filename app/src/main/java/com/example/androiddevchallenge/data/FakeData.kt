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
package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.androiddevchallenge.R

/**
 * Summary:
 * 假数据
 * @author hongcn
 * @date 2021/3/2 14:10
 */
class FakeData {

    companion object {
        val pokemons by mutableStateOf(
            listOf(
                Pokemon(
                    "ピカチュウ", "皮卡丘", "0.4m", "6kg",
                    "陆地/精灵", "雷电", R.drawable.pikaq,R.color.p_piakaq
                ),

                Pokemon(
                    "フシギダネ ", "妙蛙种子", "0.7m", "6.9kg",
                    "植物/怪兽", "草/毒", R.drawable.miaowaz,R.color.p_miaow
                ),
                Pokemon(
                    "ファイヤー ", "火焰鸟", "2m", "60kg",
                    "天空/神兽", "火焰", R.drawable.huoyanniao,R.color.p_huoyn
                ),
                Pokemon(
                    "フリーザー ", "急冻鸟", "1.7m", "55kg",
                    "天空/神兽", "冰雪", R.drawable.jidongn,R.color.p_jidong
                ),
            )
        )
    }
}