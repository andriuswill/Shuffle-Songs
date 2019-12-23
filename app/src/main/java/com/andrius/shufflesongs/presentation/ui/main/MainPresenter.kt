package com.andrius.shufflesongs.presentation.ui.main

import com.andrius.shufflesongs.data.models.Track
import com.andrius.shufflesongs.data.network.RequestTracks
import com.andrius.shufflesongs.domain.listeners.RequestTracksListener
import com.andrius.shufflesongs.domain.listeners.usecase.TracksUseCase
import org.json.JSONObject
import kotlin.random.Random

class MainPresenter (private val view: MainContract.View) : MainContract.Presenter, RequestTracksListener {

    override fun getTracks(){
        RequestTracks(this).execute()
    }

    override fun onSuccessfull(response: JSONObject) {
        val tracks = ArrayList<Track>()

        val jsons = response.getJSONArray("results")
        for (i in 0 until jsons.length()){
            Track.fromJson(jsons.getJSONObject(i))?.let {
                tracks.add(it)
            }
        }
        view.showTracks(tracks)
    }

    override fun onFail() {
        view.showError()
    }


}