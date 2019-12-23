package com.andrius.shufflesongs.data.network

import android.os.AsyncTask
import android.util.Log
import com.andrius.shufflesongs.domain.listeners.RequestTracksListener
import org.json.JSONObject
import java.net.URL

class RequestTracks(private val tracksListener: RequestTracksListener) : AsyncTask<String, Void, JSONObject>() {

    override fun doInBackground(vararg arg: String): JSONObject? {
        return try {
            val response = URL(URL_BASE + URL_PARAMS).openConnection().apply {
                readTimeout = 800
                connectTimeout = 200
            }.getInputStream().bufferedReader().readLine()
            JSONObject(response)
        } catch (e: Exception) {
            Log.d("NINJA", e.message)
            null
        }
    }

    override fun onPostExecute(result: JSONObject?) {
        super.onPostExecute(result)
        if (result == null){
            tracksListener.onFail()
        } else {
            tracksListener.onSuccessfull(result)
        }
    }

    companion object {
        const val URL_BASE = "https://us-central1-tw-exercicio-mobile.cloudfunctions.net/"
        const val URL_PARAMS = "lookup?id=909253,1171421960,358714030,1419227,264111789&limit=3"
       // const val URL_PARAMS = "lookup?id=909253,1171421960,358714030&limit=3"
    }
}