package com.andrius.shufflesongs.data.network

import android.graphics.Bitmap
import android.os.AsyncTask
import android.widget.ImageView
import android.graphics.BitmapFactory
import android.util.Log
import java.net.URL


class RequestImage(val img: ImageView, val url: String) : AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg arg: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val res = URL(url).openStream()
            bitmap = BitmapFactory.decodeStream(res)
        } catch (e: Exception) {
            Log.e("Error", e.message)
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap) {
        img.setImageBitmap(result)

    }
}