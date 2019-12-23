package com.andrius.shufflesongs.domain.listeners.usecase

import com.andrius.shufflesongs.data.models.Track
import kotlin.random.Random

class TracksUseCase {
    companion object {
        fun sortTracks(allTracks: ArrayList<Track>): ArrayList<Track>{
            val sortedTrack = ArrayList<Track>()
            val currentTracks = ArrayList<Track>()
            val nextTrack = ArrayList<Track>()
            currentTracks.addAll(allTracks)

            while (currentTracks.isNotEmpty()){
                nextTrack.clear()
                if (sortedTrack.isEmpty()){
                    nextTrack.addAll(currentTracks)
                } else {
                    for(item in currentTracks){
                        if (sortedTrack.last().artist != item.artist ){
                            nextTrack.add(item)
                        }
                    }
                    if (nextTrack.isEmpty()){
                        nextTrack.addAll(currentTracks)
                    }
                }
                Random.nextInt(0, nextTrack.size).let {
                    val track = nextTrack[it]
                    sortedTrack.add(track)
                    currentTracks.remove(track)
                }
            }
            return sortedTrack
        }
    }
}