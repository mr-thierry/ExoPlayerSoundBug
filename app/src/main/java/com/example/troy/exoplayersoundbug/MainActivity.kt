package com.example.troy.exoplayersoundbug

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class MainActivity : AppCompatActivity() {

    private lateinit var player: SimpleExoPlayer
    private lateinit var exoPlayerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exoPlayerView = findViewById(R.id.exoPlayerView)
        findViewById<View>(R.id.button).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                toggleSound();
            }

        })

        createExoPlayer()
        attachPlayerToView()
        preparePlayer()


    }

    private fun createExoPlayer() {
        val bandwidthMeter = DefaultBandwidthMeter()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)

    }

    private fun attachPlayerToView() {
        exoPlayerView.player = player;
    }

    private fun preparePlayer() {
        val bandwidthMeter = DefaultBandwidthMeter()
        val dataSourceFactory = DefaultDataSourceFactory(this, "dummy", bandwidthMeter)
        val videoSource = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse("http://mirrors.standaloneinstaller.com/video-sample/page18-movie-4.mp4"))

        player.prepare(videoSource)
        player.playWhenReady = true
    }

    private fun toggleSound() {
        if (player.volume == 0F) {
            player.volume = 1F
        } else {
            player.volume = 0F
        }
    }
}
