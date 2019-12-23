package com.andrius.shufflesongs.presentation.ui.main


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrius.shufflesongs.R
import com.andrius.shufflesongs.data.models.Track
import com.andrius.shufflesongs.presentation.adapters.TracksAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter = MainPresenter(this)
    private val tracksAdapter: TracksAdapter by lazy { TracksAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        presenter.getTracks()

        recyclerview_tracks.layoutManager = LinearLayoutManager(this)
        recyclerview_tracks.adapter = tracksAdapter
    }

    override fun showTracks(tracks: ArrayList<Track>){
        hideLoader()
        tracksAdapter.updateList(tracks)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort -> {
                tracksAdapter.sortTracks()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoader() {
        progress_loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progress_loader.visibility = View.GONE
    }

    override fun showError() {
        hideLoader()
        Toast.makeText(this, resources.getString(R.string.erro_tracks), Toast.LENGTH_LONG).show()
    }
}