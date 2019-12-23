package com.andrius.shufflesongs.presentation.ui.main

import com.andrius.shufflesongs.data.models.Track

interface MainContract {

    interface View {

        fun showTracks(tracks: ArrayList<Track>)
        fun showLoader()
        fun hideLoader()
        fun showError()

    }

    interface Presenter {

        fun getTracks()
    }

}