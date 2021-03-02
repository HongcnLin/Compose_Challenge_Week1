package com.example.composetest

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import java.io.Serializable

/**
 * Summary:
 *
 * @author hongcn
 * @date 2021/3/2 11:56
 */
data class Pokemon(
    val name: String,
    val cnName: String,
    val stature: String,
    val weight: String,
    val species: String,
    val attribute: String,
    @DrawableRes val pictureResId: Int,
    @ColorInt val bgColorId: Int
) : Serializable
