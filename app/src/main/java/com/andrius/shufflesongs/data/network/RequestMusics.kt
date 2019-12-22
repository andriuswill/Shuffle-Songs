package com.andrius.shufflesongs.data.network

import android.os.AsyncTask
import org.json.JSONObject
import java.net.URL

class RequestMusics: AsyncTask <String, Void, JSONObject>(){

    override fun doInBackground(vararg arg: String): JSONObject {

        val response = URL(URL_BASE + URL_PARAMS).openConnection().apply {
            readTimeout = 800
            connectTimeout = 200
        }.getInputStream().bufferedReader().readLine()

        return JSONObject(response)
    }

    override fun onPostExecute(result: JSONObject?) {
        super.onPostExecute(result)
    }

    companion object {
        const val URL_BASE = "https://us-central1-tw-exercicio-mobile.cloudfunctions.net/lookup?id=909253,1171421960,358714030&limit=1"
        const val URL_PARAMS = "lookup?id=909253,1171421960,358714030,1419227,264111789&limit=1"

    }
}