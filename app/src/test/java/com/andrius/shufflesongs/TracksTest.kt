package com.andrius.shufflesongs

import com.andrius.shufflesongs.data.models.Track
import com.andrius.shufflesongs.domain.listeners.usecase.TracksUseCase
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TracksTest {

    val tracks = arrayListOf(
        Track(id = 0, title = "teste", artist = "artist1", imgUrl = "url"),
        Track(id = 0, title = "teste", artist = "artist1", imgUrl = "url"),
        Track(id = 0, title = "teste", artist = "artist2", imgUrl = "url"),
        Track(id = 0, title = "teste", artist = "artist2", imgUrl = "url"),
        Track(id = 0, title = "teste", artist = "artist3", imgUrl = "url"),
        Track(id = 0, title = "teste", artist = "artist3", imgUrl = "url"))

    @Test
    fun testSort(){
        val sortedTracks = TracksUseCase.sortTracks(tracks)

        var isSameArtist = false
        for (i in 0 until sortedTracks.size - 1){
            if(sortedTracks[i].artist == sortedTracks[i+1].artist){
                isSameArtist = true
            }
        }
        Assert.assertEquals(isSameArtist, false)
    }
}
