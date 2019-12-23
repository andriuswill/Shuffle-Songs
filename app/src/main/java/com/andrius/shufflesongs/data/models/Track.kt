package com.andrius.shufflesongs.data.models

import org.json.JSONObject

class Track(
    val id: Int,
    val imgUrl: String,
    val title: String,
    val artist: String) {
    companion object {
        fun fromJson(json: JSONObject): Track? {
            return try {
                Track(
                    json.getInt("id"),
                    json.getString("artworkUrl"),
                    json.getString("trackName"),
                    json.getString("artistName")
                )
            } catch (e: Exception){
                null
            }
        }
    }
}