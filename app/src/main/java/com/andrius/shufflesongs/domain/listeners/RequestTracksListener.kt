package com.andrius.shufflesongs.domain.listeners

import org.json.JSONObject

interface RequestTracksListener {
    fun onSuccessfull(response: JSONObject)
    fun onFail()
}