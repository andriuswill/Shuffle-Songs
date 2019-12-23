package com.andrius.shufflesongs.domain.listeners

import android.graphics.Bitmap
import org.json.JSONObject

interface RequestImageListener {
    fun onSuccessfull(response: Bitmap)
    fun onFail()
}