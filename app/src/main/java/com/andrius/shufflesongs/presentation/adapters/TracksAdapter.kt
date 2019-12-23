package com.andrius.shufflesongs.presentation.adapters

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrius.shufflesongs.R
import com.andrius.shufflesongs.data.models.Track
import com.andrius.shufflesongs.data.network.RequestImage
import com.andrius.shufflesongs.domain.listeners.usecase.TracksUseCase
import kotlinx.android.synthetic.main.item_track.view.*

class TracksAdapter: RecyclerView.Adapter<TracksAdapter.TrackViewHolder>() {

    val tracks = arrayListOf<Track>()
    val sortedTracks = arrayListOf<Track>()

    fun updateList(newTracks: ArrayList<Track>){
        tracks.clear()
        tracks.addAll(newTracks)
        sortTracks()
    }

    fun sortTracks(){
        sortedTracks.clear()
        sortedTracks.addAll(TracksUseCase.sortTracks(tracks))
        notifyDataSetChanged()
    }

    override fun getItemCount() = sortedTracks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false))

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bindView(sortedTracks[position], position == itemCount - 1)
    }

    class TrackViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

        fun bindView(track: Track, isLast: Boolean) {
            with(itemView) {
                img_track.setImageResource(android.R.color.transparent)
                RequestImage(img_track, track.imgUrl, context.resources).execute()
                text_title.text = track.title
                text_artist.text = track.artist
                if (isLast){
                    view_line.visibility = View.INVISIBLE
                } else {
                    view_line.visibility = View.VISIBLE
                }
            }
        }
    }
}