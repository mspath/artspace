package com.example.compose.artspace

import androidx.annotation.DrawableRes

data class Exhibit(val title: String,
                   val artist: String,
                   val year: Int,
                   @DrawableRes val image: Int)

object ArtSpace {
    val exhibition = listOf(
        Exhibit("nr 4",
            "list",
            1994,
            R.drawable.l_4
        ),
        Exhibit("nr 6",
            "list",
            1994,
            R.drawable.l_6
        ),
        Exhibit("nr 7",
            "list",
            1994,
            R.drawable.l_7
        ),
        Exhibit("nr 8",
            "list",
            1994,
            R.drawable.l_8
        ),
        Exhibit("nr 9",
            "list",
            1994,
            R.drawable.l_9
        ),
        Exhibit("nr 11",
            "list",
            1994,
            R.drawable.l_11
        ),
        Exhibit("nr 12",
            "list",
            1994,
            R.drawable.l_12
        ),
        Exhibit("nr 31",
            "list",
            1994,
            R.drawable.l_31
        ),
        Exhibit("nr 33",
            "list",
            1994,
            R.drawable.l_33
        ),
        Exhibit("nr 45",
            "list",
            1994,
            R.drawable.l_45
        )
    )
}