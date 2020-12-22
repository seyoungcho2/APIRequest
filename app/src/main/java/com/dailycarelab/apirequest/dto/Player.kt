package com.dailycarelab.apirequest.dto

import com.google.gson.annotations.SerializedName

data class PlayerList(
    @SerializedName("data")
    val playerList : List<Player>
)

data class Player(
    val playerId: Int,
    var firstName: String,
    var heightFeet: String,
    var heightInches : String,
    var lastName: String,
    var fullName : String,
    var position : String,
    var teamId : Int,
    var team : String,
    var firstGameDate : String,
    var lastGameDate : String
)
